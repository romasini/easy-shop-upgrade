package ru.romasini.easy.shop.upgrade.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import ru.romasini.easy.shop.upgrade.entities.Profile;

import java.util.Date;

@Data
@NoArgsConstructor
public class ProfileDto {
    private Long id;
    private String username;
    private String firstname;
    private String lastname;
    private String phone;
    private String email;
    private Date birthdate;
    private String sex;
    private String address;

    public ProfileDto(Profile profile){
        this.id = profile.getId();
        this.username = profile.getUser().getUsername();
        this.firstname = profile.getFirstname();
        this.lastname = profile.getLastname();
        this.phone = profile.getPhone();
        this.email = profile.getEmail();
        this.birthdate = profile.getBirthdate();
        this.sex = profile.getSex();
        this.address = profile.getAddress();
    }
}
