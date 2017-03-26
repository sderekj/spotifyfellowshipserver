package nyc.c4q.dereksantos.server;

import java.util.*;

public class UserService {

    private Map<String, User> users = new HashMap<>();

    public List<User> getAllUsers() {
        return new ArrayList<>(users.values());
    }

    public User getUser(String id) {
        return users.get(id);
    }

    public User createUser(String name, String favoriteCity) {
        failIfInvalid(name, favoriteCity);
        User user = new User(name, favoriteCity);
        users.put(user.getId(), user);
        return user;
    }

    public User updateUser(String id, String name, String favoriteCity) {
        User user = users.get(id);
        if (user == null) {
            throw new IllegalArgumentException("No person with id '" + id + "' found");
        }
//        failIfInvalid(name, favoriteCity);
        if (name != null) {
            user.setName(name);
        }
        if (favoriteCity != null) {
            user.setFavoriteCity(favoriteCity);
        }
        return user;
    }

    private void failIfInvalid(String name, String favoriteCity) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Parameter 'name' cannot be empty");
        }
        if (favoriteCity == null || favoriteCity.isEmpty()) {
            throw new IllegalArgumentException("Parameter 'favorite city' cannot be empty");
        }
    }

    /*
    private void failIfInvalid2(String name, String favoriteCity) {
        if ((name == null || name.isEmpty())
                &&
                (favoriteCity == null || favoriteCity.isEmpty())) {
            throw new IllegalArgumentException("Both parameters cannot be empty");
        }
    }
    */
}
