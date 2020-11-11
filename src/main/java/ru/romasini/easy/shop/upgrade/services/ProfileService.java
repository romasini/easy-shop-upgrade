package ru.romasini.easy.shop.upgrade.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.romasini.easy.shop.upgrade.entities.Profile;
import ru.romasini.easy.shop.upgrade.repositories.ProfileRepository;

@Service
@RequiredArgsConstructor
public class ProfileService {
    private final ProfileRepository profileRepository;

    public Profile save(Profile profile){
        return profileRepository.save(profile);
    }

}
