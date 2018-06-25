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
import de.htwg.cityyanderecarcassonne.controller.ICarcassonneController;
import de.htwg.cityyanderecarcassonne.model.IPlayer;

import java.io.IOException;
import java.util.HashMap;
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
                                path("gamestatus", () ->
                                        complete(controller.getStatus().toString())
                                ),
                                pathPrefix("addplayer", () ->
                                        path(PathMatchers.remaining(), name ->
                                                addPlayer(name)
                                        )
                                ),
                                path("creategame", () -> {
                                    controller.create();
                                    controller.startRound();
                                    return complete(StatusCodes.OK);
                                }),
                                path("currentplayer", () ->
                                        complete("currentplayer")
                                ),
                                path("allplayers", () ->
                                        complete("allplayers")
                                ),
                                path("currentcard", () ->
                                        complete("currentcard")
                                ),
                                pathPrefix("rotatecard", () ->
                                        path(PathMatchers.remaining(), direction ->
                                                rotateCard(direction)
                                        )
                                ),
                                path("cardcount", () ->
                                        complete("cardcount")
                                ),
                                path("cardposslist", () ->
                                        complete("cardposslist")
                                ),
                                pathPrefix("placecard", () ->
                                        pathPrefix(PathMatchers.remaining(), selector ->
                                                path(PathMatchers.remaining(), position ->
                                                        complete(selector + ":" + position)
                                                )
                                        )
                                ),
                                path("meepleposslist", () ->
                                        complete("meepleposslist")
                                ),
                                pathPrefix("placemeeple", () ->
                                        pathPrefix(PathMatchers.segment(), selector ->
                                                path(PathMatchers.remaining(), position ->
                                                        complete(selector + ":" + position)
                                                )
                                        )
                                ),
                                path("gettownsquare", () ->
                                        complete("gettownsquare")
                                ),
                                path("finnishround", () ->
                                        complete("finnishround")
                                )
                            )
        );
    }

    private Route addPlayer(String name) {
        controller.addPlayer(name);

        IPlayer controllerPlayer = controller.getPlayers().get(controller.getPlayers().size() - 1);

        String pid = "pid_" + playerIdMap.size();
        playerIdMap.put(controllerPlayer, pid);

        return complete("kay lah");
    }

    private Route rotateCard(String direction) {
        if ("left".equals(direction)) {
            controller.rotateCardLeft();
        } else if ("right".equals(direction)) {
            controller.rotateCardRight();
        } else {
            return complete(StatusCodes.BAD_REQUEST, "Unknown direction. Only \"left\" and \"right\" possible.");
        }
        return complete("getCurrentCard()"); //TODO
    }
}
