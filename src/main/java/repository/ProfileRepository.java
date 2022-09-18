package repository;

import models.User;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class ProfileRepository {

    private Map<UUID, User> map;

    public ProfileRepository() {
        this.map = new HashMap<>();
    }

    public void addUser(User user) {
        this.map.put(user.getId(), user);
    }


}
