package de.htwg.cityyanderecarcassonne.controller.microservice;

import akka.NotUsed;
import akka.actor.ActorSystem;
import akka.http.javadsl.ConnectHttp;
import akka.http.javadsl.Http;
import akka.http.javadsl.ServerBinding;
import akka.http.javadsl.model.HttpRequest;
import akka.http.javadsl.model.HttpResponse;
import akka.http.javadsl.server.AllDirectives;
import akka.http.javadsl.server.Route;
import akka.stream.ActorMaterializer;
import akka.stream.javadsl.Flow;
import de.htwg.cityyanderecarcassonne.controller.ICarcassonneController;

import java.io.IOException;
import java.util.concurrent.CompletionStage;

public class CarcassonneMicroserviceController extends AllDirectives {

    private ICarcassonneController controller;

    private final static String HOST_IP   = "localhost";
    private final static int    HOST_PORT = 8080;

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
        return route(
                pathPrefix("hello", () ->
                    get(() ->
                        complete("<h1>Say hello to akka-http</h1>"))));
    }
}
