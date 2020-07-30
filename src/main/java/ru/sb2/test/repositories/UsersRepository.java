package ru.sb2.test.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.sb2.test.domains.Users;

@Repository
public interface UsersRepository extends CrudRepository<Users, String> {
    Users findByLogin(String login);
}
