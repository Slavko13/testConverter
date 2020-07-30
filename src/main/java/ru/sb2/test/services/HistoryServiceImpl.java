package ru.sb2.test.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sb2.test.domains.History;
import ru.sb2.test.domains.Users;
import ru.sb2.test.domains.Valute;
import ru.sb2.test.repositories.HistoryRepository;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.List;

@Service
public class HistoryServiceImpl implements HistoryService {

    @Autowired
    private ValuteService valuteService;

    @Autowired
    private HistoryRepository historyRepository;


    @Override
    public List<History> getHistoryByTargetValuteAndSourceValuteAndLocalDate(String sourceValue, String targetValue, Users user, LocalDate localDate) {
        return historyRepository.findAllBySourceValuteAndTargetValuteAndUserAndLocalDateOrderByIdDesc(sourceValue, targetValue, user, localDate);
    }

    @Override
    public List<History> getFullHistoryByUserId(String login) {
        return historyRepository.findAllByUserLoginOrderByIdDesc(login);
    }


    @Override
    public History convertSaveHistory(History history, Users user) {
        double convertResult =  valuteService.convert(history.getSourceValute(), history.getTargetValute(), history.getSourceValuteValue());
        history.setTargetValuteValue(convertResult);
        history.setUser(user);
        history.setLocalDate(LocalDate.now());
        return historyRepository.save(history);
    }

}
