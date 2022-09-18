package services;

import models.User;
import repository.ProfileRepository;

import java.util.UUID;

public class ProfileService {
    private final ProfileRepository profileRepository;

    public ProfileService(ProfileRepository profileRepository) {

        this.profileRepository = profileRepository;
    }


    // add user
    public void addUser(String name, UUID id) {
        User user = User.builder().name(name).id(id).build();

        profileRepository.addUser(user);
    }

}
