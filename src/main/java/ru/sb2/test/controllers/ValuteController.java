package ru.sb2.test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;
import ru.sb2.test.domains.History;
import ru.sb2.test.domains.Users;
import ru.sb2.test.domains.Valute;
import ru.sb2.test.services.HistoryService;
import ru.sb2.test.services.UsersService;
import ru.sb2.test.services.ValuteService;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;

@RequestMapping("valute")
@RestController
public class ValuteController {

    @Autowired
    private HistoryService historyService;

    @Autowired
    private ValuteService valuteService;

    @Autowired
    private UsersService userService;


    @PostMapping
    public History convert(@RequestBody History history, @AuthenticationPrincipal Users user) {

        return historyService.convertSaveHistory(history, user);
    }

    @PostMapping("/search")
    public List<History> search(@RequestBody History history, @AuthenticationPrincipal Users user) {
        List<History>  histories = historyService.getHistoryByTargetValuteAndSourceValuteAndLocalDate(history.getSourceValute(), history.getTargetValute(), user, history.getLocalDate());

        return histories;
    }

}
