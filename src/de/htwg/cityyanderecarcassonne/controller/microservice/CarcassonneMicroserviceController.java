package de.htwg.cityyanderecarcassonne.controller.microservice;

import akka.NotUsed;
import akka.actor.ActorSystem;
import akka.http.javadsl.ConnectHttp;
import akka.http.javadsl.Http;
import akka.http.javadsl.ServerBinding;
import akka.http.javadsl.model.HttpRequest;
import akka.http.javadsl.model.HttpResponse;
import akka.http.javadsl.model.StatusCodes;
import akka.http.javadsl.server.AllDirectives;
import akka.http.javadsl.server.PathMatchers;
import akka.http.javadsl.server.Route;
import akka.stream.ActorMaterializer;
import akka.stream.javadsl.Flow;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import de.htwg.cityyanderecarcassonne.controller.ICarcassonneController;
import de.htwg.cityyanderecarcassonne.controller.microservice.pojos.*;
import de.htwg.cityyanderecarcassonne.model.ICard;
import de.htwg.cityyanderecarcassonne.model.IPlayer;
import de.htwg.cityyanderecarcassonne.model.IPosition;
import de.htwg.cityyanderecarcassonne.model.IRegion;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletionStage;

public class CarcassonneMicroserviceController extends AllDirectives {

    private final static String HOST_IP   = "localhost";
    private final static int    HOST_PORT = 8080;

    private ICarcassonneController controller;

    private Map<IPlayer, String> playerIdMap = new HashMap<>();
    private String lastCardPosition;

    public CarcassonneMicroserviceController(ICarcassonneController controller) {
        this.controller = controller;
    }

    public void runMicroservice() throws IOException {
        ActorSystem system = ActorSystem.create("cyccontroller");

        final Http http = Http.get(system);
        final ActorMaterializer materializer = ActorMaterializer.create(system);

        CarcassonneMicroserviceController cmsc = new CarcassonneMicroserviceController(controller);

        final Flow<HttpRequest, HttpResponse, NotUsed> routeFlow = cmsc.createRoute().flow(system, materializer);
        final CompletionStage<ServerBinding> binding = http.bindAndHandle(routeFlow,
                ConnectHttp.toHost(HOST_IP, HOST_PORT), materializer);

        System.out.println(this.getClass().getSimpleName() + " has started listening on http://" + HOST_IP + ":" + HOST_PORT);
        System.out.println("Press RETURN to stop the microservice...");
        System.in.read();

        binding
                .thenCompose(ServerBinding::unbind)
                .thenAccept(unbound -> system.terminate());
    }

    private Route createRoute() {
        return pathPrefix("cyc", () ->
                route(
                        pathPrefix("gamestatus", () ->
                                pathSingleSlash(this::getGameStatus)),
                        pathPrefix("addplayer", () ->
                                        path(PathMatchers.remaining(), this::addPlayer)
                        ),
                        path("creategame", this::createGame),
                        path("currentplayer", this::getCurrentPlayerId),
                        path("allplayers", this::getAllPlayers),
                        path("currentcard", this::getCurrentCard),
                                pathPrefix("rotatecard", () ->
                                        path(PathMatchers.remaining(), this::rotateCard)
                                ),
                        path("cardcount", this::getRemainingCards),
                        path("cardposslist", this::getCardPossibilities),
                        pathPrefix("placecard", () ->
                                        pathPrefix(PathMatchers.segment(), selector ->
                                                path(PathMatchers.remaining(), position ->
                                                        placeCard(selector, position)
                                                )
                                        )
                                ),
                        path("meepleposslist", this::getMeeplePossibilities),
                        pathPrefix("placemeeple", () ->
                                        pathPrefix(PathMatchers.remaining(), this::placeMeeple)
                        ),
                        path("gettownsquare", this::getTownsquare),
                        path("finishround", this::finishRound)
                )
        );
    }

    private Route getGameStatus() {
        return complete(controller.getStatus().toString());
    }

    private Route addPlayer(String name) {
        controller.addPlayer(name);

        IPlayer controllerPlayer = controller.getPlayers().get(controller.getPlayers().size() - 1);

        String pid = "pid_" + playerIdMap.size();
        playerIdMap.put(controllerPlayer, pid);

        return complete(jsonConverter(convertPlayer(controllerPlayer)));
    }

    private Route getAllPlayers() {
        List<IPlayer> players = controller.getPlayers();
        List<Player> jsonPlayers = new ArrayList<>();
        for (IPlayer player : players) {
            jsonPlayers.add(convertPlayer(player));
        }

        return complete(jsonConverter(jsonPlayers));
    }

    private Player convertPlayer(IPlayer player) {
        Player jsonPlayer = new Player();

        jsonPlayer.pid = playerIdMap.get(player);
        jsonPlayer.name = player.getName();
        jsonPlayer.meeple = player.getSumMeeples();
        jsonPlayer.score = player.getScore();

        return jsonPlayer;
    }

    private Route createGame() {
        controller.create();
        controller.startRound();
        return complete(StatusCodes.OK);
    }

    private Route getCurrentPlayerId() {
        return complete(playerIdMap.get(controller.getCurrentPlayer()));
    }

    private Route getCurrentCard() {
        return complete(jsonConverter(cardConvert(controller.cardOnHand())));
    }

    private Route rotateCard(String direction) {
        if ("left".equals(direction)) {
            controller.rotateCardLeft();
        } else if ("right".equals(direction)) {
            controller.rotateCardRight();
        } else {
            return complete(StatusCodes.BAD_REQUEST, "Unknown direction. Only \"left\" and \"right\" possible.");
        }
        return getCurrentCard();
    }

    private CurrentCard cardConvert(ICard icard) {
        CurrentCard currCard = new CurrentCard();
        currCard.cardname = cardConvertName(icard);
        currCard.orientation = icard.getOrientation();

        return currCard;
    }

    private String cardConvertName(ICard icard) {
        return icard.toString().substring(icard.toString().lastIndexOf(" ") + 1);
    }

    private Route getRemainingCards() {
        return complete(String.valueOf(controller.getRemainingCards()));
    }

    private Route getCardPossibilities() {
        Map<IPosition, String> possMap = controller.getCardPossibilitiesMap(controller.cardOnHand());
        List<PossCardPos> possList = new ArrayList<>();
        for (Map.Entry<IPosition, String> entry : possMap.entrySet()){
            PossCardPos cardPos = new PossCardPos();
            cardPos.selector = entry.getValue();
            cardPos.position = entry.getKey().getY() + "_" + entry.getKey().getX();
            possList.add(cardPos);
        }

        return complete(jsonConverter(possList));
    }

    private Route placeCard(String selection, String position) {
        lastCardPosition = position;
        controller.placeCard(controller.cardOnHand(), selection);
        return getGameStatus();
    }

    private Route getMeeplePossibilities() {
        ICard card = controller.cardOnHand();

        Map<IRegion, String> possMap = controller.getRegionPossibilitiesMap(card);

        TSCard tscard = new TSCard();
        tscard.position = lastCardPosition;
        tscard.name = cardConvertName(card);
        tscard.orientation = card.getOrientation();
        tscard.regions = new HashMap<>();
        for (Map.Entry<IRegion, String> entry : possMap.entrySet()) {
            if (entry.getKey().equals(card.getLeftTop()))
                tscard.regions.put("LT", entry.getValue());
            if (entry.getKey().equals(card.getLeftMiddle()))
                tscard.regions.put("LM", entry.getValue());
            if (entry.getKey().equals(card.getLeftBelow()))
                tscard.regions.put("LB", entry.getValue());

            if (entry.getKey().equals(card.getBelowLeft()))
                tscard.regions.put("BL", entry.getValue());
            if (entry.getKey().equals(card.getBelowMiddle()))
                tscard.regions.put("BM", entry.getValue());
            if (entry.getKey().equals(card.getBelowRight()))
                tscard.regions.put("BR", entry.getValue());

            if (entry.getKey().equals(card.getCenterMiddle()))
                tscard.regions.put("C", entry.getValue());

            if (entry.getKey().equals(card.getTopLeft()))
                tscard.regions.put("TL", entry.getValue());
            if (entry.getKey().equals(card.getTopMiddle()))
                tscard.regions.put("TM", entry.getValue());
            if (entry.getKey().equals(card.getTopRight()))
                tscard.regions.put("TR", entry.getValue());

            if (entry.getKey().equals(card.getRightTop()))
                tscard.regions.put("RT", entry.getValue());
            if (entry.getKey().equals(card.getRightMiddle()))
                tscard.regions.put("RM", entry.getValue());
            if (entry.getKey().equals(card.getRightBelow()))
                tscard.regions.put("RB", entry.getValue());
        }

        return complete(jsonConverter(tscard));
    }

    private Route placeMeeple(String selection) {
        controller.placeMeeple(controller.getCurrentPlayer(), controller.cardOnHand(), selection);
        return getGameStatus();
    }

    private Route getTownsquare() {
        de.htwg.cityyanderecarcassonne.model.townsquare.Townsquare cts = controller.getTownsquare();

        Townsquare ts = new Townsquare();
        ts.cards = new ArrayList<>();
        for (int x = 0; x < cts.getDimX(); x++) {
            for (int y = 0; y < cts.getDimY(); y++) {
                ICard ctsCard = cts.getCard(x, y);
                if (ctsCard != null) {
                    TSCard card = new TSCard();
                    card.position = y + "_" + x;
                    card.name = cardConvertName(ctsCard);
                    card.orientation = ctsCard.getOrientation();
                    card.regions = new HashMap<>();

                    if (ctsCard.getLeftTop().getPlayer() != null)
                        card.regions.put("LT", playerIdMap.get(ctsCard.getLeftTop().getPlayer()));
                    if (ctsCard.getLeftMiddle().getPlayer() != null)
                        card.regions.put("LM", playerIdMap.get(ctsCard.getLeftMiddle().getPlayer()));
                    if (ctsCard.getLeftBelow().getPlayer() != null)
                        card.regions.put("LB", playerIdMap.get(ctsCard.getLeftBelow().getPlayer()));

                    if (ctsCard.getTopLeft().getPlayer() != null)
                        card.regions.put("TL", playerIdMap.get(ctsCard.getTopLeft().getPlayer()));
                    if (ctsCard.getTopMiddle().getPlayer() != null)
                        card.regions.put("TM", playerIdMap.get(ctsCard.getTopMiddle().getPlayer()));
                    if (ctsCard.getTopRight().getPlayer() != null)
                        card.regions.put("TR", playerIdMap.get(ctsCard.getTopRight().getPlayer()));

                    if (ctsCard.getCenterMiddle().getPlayer() != null)
                        card.regions.put("C", playerIdMap.get(ctsCard.getCenterMiddle().getPlayer()));

                    if (ctsCard.getBelowLeft().getPlayer() != null)
                        card.regions.put("BL", playerIdMap.get(ctsCard.getBelowLeft().getPlayer()));
                    if (ctsCard.getBelowMiddle().getPlayer() != null)
                        card.regions.put("BM", playerIdMap.get(ctsCard.getBelowMiddle().getPlayer()));
                    if (ctsCard.getBelowRight().getPlayer() != null)
                        card.regions.put("BR", playerIdMap.get(ctsCard.getBelowRight().getPlayer()));

                    if (ctsCard.getRightTop().getPlayer() != null)
                        card.regions.put("RT", playerIdMap.get(ctsCard.getRightTop().getPlayer()));
                    if (ctsCard.getRightMiddle().getPlayer() != null)
                        card.regions.put("RM", playerIdMap.get(ctsCard.getRightMiddle().getPlayer()));
                    if (ctsCard.getRightBelow().getPlayer() != null)
                        card.regions.put("RB", playerIdMap.get(ctsCard.getRightBelow().getPlayer()));

                    ts.cards.add(card);
                }
            }
        }

        return complete(jsonConverter(ts));
    }

    private Route finishRound() {
        controller.finishRound();
        return complete(StatusCodes.OK);
    }

    private String jsonConverter(Object obj) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            return mapper.writeValueAsString(obj);
        } catch (JsonProcessingException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    private Object jsonConverter(String json, Class className) {
        ObjectMapper mapper = new ObjectMapper();

        try {
            return mapper.readValue(json, className);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
