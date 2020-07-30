package ru.sb2.test.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.sb2.test.domains.Roles;
import ru.sb2.test.domains.Users;
import ru.sb2.test.repositories.UsersRepository;
import ru.sb2.test.utils.UserValidator;

import java.util.Set;

@Service
public class UsersServiceImpl implements UsersService {



    @Autowired
    private UserValidator userValidator;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Users findByLogin(String login) {
        return usersRepository.findByLogin(login);
    }

    @Override
    public boolean addUser(Users user, Set<Roles> roles) {

        if (userValidator.validate(user)) {
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            user.setRoles(roles);

            usersRepository.save(user);
            return true;
        }


        return false;
    }


}
