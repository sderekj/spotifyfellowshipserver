package nyc.c4q.dereksantos.server;

import java.util.UUID;

public class User {

    static int instanceCounter = 1;
    private String id;
    private String name;
    private String favoriteCity;

    public User(String name, String favoriteCity) {
        this.id = String.valueOf(instanceCounter++);
        this.name = name;
        this.favoriteCity = favoriteCity;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFavoriteCity() {
        return favoriteCity;
    }

    public void setFavoriteCity(String favoriteCity) {
        this.favoriteCity = favoriteCity;
    }
}
