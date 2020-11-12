package ru.romasini.easy.shop.upgrade.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import ru.romasini.easy.shop.upgrade.dto.ProfileDto;
import ru.romasini.easy.shop.upgrade.entities.Profile;
import ru.romasini.easy.shop.upgrade.entities.User;
import ru.romasini.easy.shop.upgrade.exceptions.MarketError;
import ru.romasini.easy.shop.upgrade.exceptions.ResourceNotFoundException;
import ru.romasini.easy.shop.upgrade.services.ProfileService;
import ru.romasini.easy.shop.upgrade.services.UserService;

import java.security.Principal;
import java.util.Map;

@RequestMapping("/api/v1/profile")
@RestController
@RequiredArgsConstructor
public class ProfileController {
    private final ProfileService profileService;
    private final UserService userService;
    private final BCryptPasswordEncoder passwordEncoder;

    @GetMapping(produces = "application/json")
    public ProfileDto getProfile(Principal principal){
        User user = userService.findByUsername(principal.getName()).orElseThrow(()-> new UsernameNotFoundException(String.format("User '%s' not found", principal.getName())));
        return new ProfileDto(user.getProfile());
    }

    @PutMapping
    public ResponseEntity<?> updateProfile(@RequestBody ProfileDto profileDto,
                                        @RequestParam String password,
                                        Principal principal){
        User user = userService.findByUsername(principal.getName()).orElseThrow(()-> new UsernameNotFoundException(String.format("User '%s' not found", principal.getName())));
        if(!passwordEncoder.matches(password, user.getPassword())) {
            return new ResponseEntity<>(new MarketError(HttpStatus.BAD_REQUEST.value(),"Incorrect Password"), HttpStatus.BAD_REQUEST);
        };
        Profile profile = user.getProfile();
        profile.setAddress(profileDto.getAddress());
        profile.setBirthdate(profileDto.getBirthdate());
        profile.setEmail(profileDto.getEmail());
        profile.setPhone(profileDto.getPhone());
        profile.setLastname(profileDto.getLastname());
        profile.setFirstname(profileDto.getFirstname());
        profile.setSex(profileDto.getSex());
        profile = profileService.save(profile);
        return new ResponseEntity<>(new ProfileDto(profile), HttpStatus.OK);
    }
}
