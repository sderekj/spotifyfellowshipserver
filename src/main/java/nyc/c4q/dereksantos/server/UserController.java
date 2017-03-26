package nyc.c4q.dereksantos.server;

import com.sun.istack.internal.Nullable;
import spark.Spark;

import static spark.Spark.*;

public class UserController {

    public UserController(final UserService userService) {

        Spark.get("/people", (req, res) -> userService.getAllUsers(), JsonUtil.json());

        Spark.get("/people/:id", (req, res) -> {
            String id = req.params(":id");
            User user = userService.getUser(id);
            if (user != null) {
                return user;
            }
            res.status(400);
            return new ResponseError("No user with id '%s' found", id);
        }, JsonUtil.json());

        Spark.post("/people", (req, res) -> userService.createUser(
                req.queryParams("name"),
                req.queryParams("favoriteCity")
        ), JsonUtil.json());

        Spark.put("/people/:id", (req, res) -> userService.updateUser(
                req.params(":id"),
                req.queryParams("name"),
                req.queryParams("favoriteCity")
        ), JsonUtil.json());

        after((req, res) -> {
            res.type("application/json");
        });

        exception(IllegalArgumentException.class, (e, req, res) -> {
            res.status(400);
            res.body(JsonUtil.toJson(new ResponseError(e)));
        });
    }
}
