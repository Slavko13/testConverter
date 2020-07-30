package ru.sb2.test.services;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import ru.sb2.test.domains.Roles;
import ru.sb2.test.domains.Users;
import ru.sb2.test.repositories.UsersRepository;
import ru.sb2.test.repositories.ValuteRepository;
import ru.sb2.test.utils.UserValidator;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;


@RunWith(SpringRunner.class)
@SpringBootTest
class UsersServiceImplTest {

    @Autowired
    private UsersService usersService;

    @MockBean
    private UsersRepository usersRepository;

    @Autowired
    private UserValidator userValidator;

    @MockBean
    private PasswordEncoder passwordEncoder;

    @Test
    void addUser() {
        Users user = new Users();
        user.setLogin("Tovana");
        Set<Roles> roles = new HashSet<>();
        boolean isUserCreated = usersService.addUser(user, roles);
        Assert.assertTrue(isUserCreated);
        Mockito.verify(usersRepository, Mockito.times(1)).save(user);
        Mockito.verify(usersRepository, Mockito.times(1)).findByLogin(user.getLogin());
    }



    @Test
    void  addUserFail() {
        Users user = new Users();
        Set<Roles> roles = new HashSet<>();
        user.setLogin("John");

        Mockito.doReturn(new Users())
                .when(usersRepository)
                .findByLogin("John");

        boolean isUserActivated = usersService.addUser(user, roles);


        Assert.assertFalse(isUserActivated);
        Mockito.verify(usersRepository, Mockito.times(0)).save(ArgumentMatchers.any(Users.class));


    }
}