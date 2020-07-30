package ru.sb2.test.services;

import ru.sb2.test.domains.History;
import ru.sb2.test.domains.Users;

import java.time.LocalDate;
import java.util.List;

public interface HistoryService {
    List<History> getFullHistoryByUserId(String login);
    List<History> getHistoryByTargetValuteAndSourceValuteAndLocalDate(String sourceValue, String targetValue, Users user, LocalDate localDate);
    History convertSaveHistory(History history,Users user);
}
