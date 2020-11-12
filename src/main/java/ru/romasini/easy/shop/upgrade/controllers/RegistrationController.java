package ru.romasini.easy.shop.upgrade.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import ru.romasini.easy.shop.upgrade.entities.Profile;
import ru.romasini.easy.shop.upgrade.entities.Role;
import ru.romasini.easy.shop.upgrade.entities.User;
import ru.romasini.easy.shop.upgrade.exceptions.ResourceNotFoundException;
import ru.romasini.easy.shop.upgrade.services.ProfileService;
import ru.romasini.easy.shop.upgrade.services.RoleService;
import ru.romasini.easy.shop.upgrade.services.UserService;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RequestMapping("/registration")
@RestController
@RequiredArgsConstructor
public class RegistrationController {
    private final ProfileService profileService;
    private final UserService userService;
    private final RoleService roleService;
    private final BCryptPasswordEncoder passwordEncoder;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveNewUser(@RequestParam String username,
                            @RequestParam String password,
                            @RequestParam Map<String, String> params){
        if(username == null || username.isBlank()) throw new ResourceNotFoundException("Username uncorrect");
        if(password == null || password.isBlank()) throw new ResourceNotFoundException("Password uncorrect");

        Date bDate = null;
        String birthdate = params.get("birthdate");
        if(birthdate != null) {
            DateFormat df = DateFormat.getInstance();
            try {
                bDate = df.parse(birthdate);
            } catch (ParseException e) {
                throw new ResourceNotFoundException("Birthdate uncorrect");
            }
        }
        if(!userService.findByUsername(username).isEmpty()) throw new ResourceNotFoundException("Username is busy");

        User newUser = new User();
        newUser.setUsername(username);
        newUser.setPassword(passwordEncoder.encode(password));

        List<Role> roles = new ArrayList<>();
        roles.add(roleService.findByName("ROLE_CUSTOMER"));
        newUser.setRoles(roles);

        String email = params.get("email");
        if(email != null) newUser.setEmail(email);

        newUser = userService.save(newUser);
        if(newUser == null) throw new ResourceNotFoundException("Try again");

        Profile profile = new Profile();
        profile.setUser(newUser);

        String firstname = params.get("firstname");
        if(firstname != null) profile.setFirstname(firstname);

        String lastname = params.get("lastname");
        if(lastname != null) profile.setLastname(lastname);

        String phone = params.get("phone");
        if(phone != null) profile.setPhone(phone);

        if(email != null) profile.setEmail(email);

        profile.setBirthdate(bDate);

        String sex =  params.get("sex");
        if(sex != null) profile.setSex(sex);

        String address =  params.get("address");
        if(address != null) profile.setAddress(address);

        profileService.save(profile);

    }

}
