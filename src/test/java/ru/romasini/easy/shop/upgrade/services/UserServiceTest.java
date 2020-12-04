package ru.romasini.easy.shop.upgrade.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import ru.romasini.easy.shop.upgrade.entities.User;
import ru.romasini.easy.shop.upgrade.repositories.UserRepository;

import java.util.Optional;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;

    @Test
    public void findByUsernameTest(){
        User user = new User();
        user.setUsername("noname");
        user.setEmail("noname@market.ru");

        Mockito.doReturn(Optional.of(user))
                .when(userRepository)
                .findByUsername("noname");

        User userNoname = userRepository.findByUsername("noname").get();
        Assertions.assertNotNull(userNoname);
        Mockito.verify(userRepository, Mockito.times(1)).findByUsername(ArgumentMatchers.eq("noname"));
    }
}
