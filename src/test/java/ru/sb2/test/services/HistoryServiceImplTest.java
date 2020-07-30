package ru.sb2.test.services;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import ru.sb2.test.domains.History;
import ru.sb2.test.domains.Users;
import ru.sb2.test.repositories.HistoryRepository;
import ru.sb2.test.repositories.ValuteRepository;

import static org.junit.jupiter.api.Assertions.*;


@RunWith(SpringRunner.class)
@SpringBootTest
class HistoryServiceImplTest {

    @MockBean
    private HistoryRepository historyRepository;

    @Autowired
    private HistoryService historyService;

    @MockBean
    private ValuteService valuteService;

    @MockBean
    private ValuteRepository valuteRepository;

    @Test
    void saveHistory() {

        History history = new History();
        history.setSourceValute("Евро");
        history.setTargetValute("Датская крона");
        history.setSourceValuteValue(5);

        Users user = new Users();


        Mockito.doReturn(30.4)
                .when(valuteService)
                .convert(history.getSourceValute(), history.getTargetValute(), history.getSourceValuteValue());

        History savedHistory = historyService.convertSaveHistory(history, user);


        Mockito.verify(valuteService, Mockito.times(1)).convert(history.getSourceValute(), history.getTargetValute(), history.getSourceValuteValue());
        Mockito.verify(historyRepository, Mockito.times(1)).save(ArgumentMatchers.any(History.class));



    }
}