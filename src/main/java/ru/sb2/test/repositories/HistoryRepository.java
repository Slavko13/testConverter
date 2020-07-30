package ru.sb2.test.repositories;

import org.apache.catalina.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.sb2.test.domains.History;
import ru.sb2.test.domains.Users;

import java.time.LocalDate;
import java.util.List;


@Repository
public interface HistoryRepository extends CrudRepository<History, Integer> {
    List<History> findAllByUserLoginOrderByIdDesc(String login);
    List<History> findAllBySourceValuteAndTargetValuteAndUserAndLocalDateOrderByIdDesc(String sourceValute, String targetValute, Users user, LocalDate localDate);
}