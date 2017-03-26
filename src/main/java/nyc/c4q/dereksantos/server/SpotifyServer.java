package nyc.c4q.dereksantos.server;

import static spark.Spark.*;

public class SpotifyServer {

    public static void main(String[] args) {
        port(getHerokuAssignedPort());
        get("/hello", (request, response) -> "Hola, Mundo!");

        new UserController(new UserService());
    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567; //return default port if heroku-port isn't set (i.e. on localhost)
    }
}
