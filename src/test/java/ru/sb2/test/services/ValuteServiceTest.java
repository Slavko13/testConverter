package ru.sb2.test.services;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import ru.sb2.test.repositories.ValuteRepository;
import ru.sb2.test.utils.UserValidator;

import static org.junit.jupiter.api.Assertions.*;



@RunWith(SpringRunner.class)
@SpringBootTest
class ValuteServiceTest {


    @Autowired
    private ValuteService valuteService;

    @MockBean
    private ValuteRepository valuteRepository;


    @Test
    void convert() {


    }
}