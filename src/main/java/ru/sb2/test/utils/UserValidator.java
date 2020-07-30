package ru.sb2.test.utils;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import ru.sb2.test.domains.Users;
import ru.sb2.test.services.UsersService;


@Component
public class UserValidator  {

    @Autowired
    private UsersService usersService;


    public boolean validate(Object o) {
        Users user = (Users) o;
        Users userFromDb = usersService.findByLogin(user.getLogin());

        if (userFromDb != null) {
           return false;
        }
        return true;
    }

}
