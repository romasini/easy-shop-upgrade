package ru.romasini.easy.shop.upgrade.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import ru.romasini.easy.shop.upgrade.dto.ProfileDto;
import ru.romasini.easy.shop.upgrade.entities.Profile;
import ru.romasini.easy.shop.upgrade.entities.User;
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

    @GetMapping
    public ProfileDto getProfile(Principal principal){
        User user = userService.findByUsername(principal.getName()).orElseThrow(()-> new UsernameNotFoundException(String.format("User '%s' not found", principal.getName())));
        return new ProfileDto(user.getProfile());
    }

    @PutMapping
    public ProfileDto updateProfile(@RequestParam String password,
                                    @RequestParam Map<String, String> params,
                                    Principal principal){
         User user = userService.findByUsername(principal.getName()).orElseThrow(()-> new UsernameNotFoundException(String.format("User '%s' not found", principal.getName())));
        if(!passwordEncoder.matches(password, user.getPassword())) throw new ResourceNotFoundException("Password uncorrect");
        Profile profile = user.getProfile();

        String firstname = params.get("firstname");
        if(firstname != null) profile.setFirstname(firstname);

        String lastname = params.get("lastname");
        if(lastname != null) profile.setLastname(lastname);

        String phone = params.get("phone");
        if(phone != null) profile.setPhone(phone);

        String email = params.get("email");
        if(email != null) profile.setEmail(email);

//        String birthdate = params.get("birthdate");
//        if(birthdate != null) {
//            DateFormat df = DateFormat.getInstance();
//            try {
//                profile.setBirthdate(df.parse(birthdate));
//            } catch (ParseException e) {
//                throw new ResourceNotFoundException("Birthdate uncorrect");
//            }
//        }

        String sex =  params.get("sex");
        if(sex != null) profile.setSex(sex);

        String address =  params.get("address");
        if(address != null) profile.setAddress(address);

        profile = profileService.save(profile);
        return new ProfileDto(profile);
    }
}
