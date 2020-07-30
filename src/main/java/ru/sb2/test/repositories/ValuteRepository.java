package ru.sb2.test.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.sb2.test.domains.Valute;


@Repository
public interface ValuteRepository extends CrudRepository<Valute, String> {
    Valute findByName(String name);
}
