package ru.sb2.test.services;

import ru.sb2.test.domains.Roles;
import ru.sb2.test.domains.Users;

import java.util.Set;

public interface UsersService {
    Users findByLogin(String login);
    boolean addUser(Users user, Set<Roles> roles);

}
