package ru.sb2.test.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.sb2.test.domains.Users;
import ru.sb2.test.services.HistoryService;
import ru.sb2.test.services.ValuteService;

import java.util.HashMap;

@Controller
@RequestMapping("valute")
public class MainController {

    @Autowired
    private ValuteService valuteService;

//    @Value("${spring.profiles.active}")
//    private String profile;

    @Autowired
    private HistoryService historyService;


    @GetMapping
    public String main(Model model, @AuthenticationPrincipal Users user) {
        HashMap<Object, Object> data = new HashMap<>();
        Users userWithOutCred = new Users();
        userWithOutCred.setLogin(user.getLogin());
        userWithOutCred.setName(user.getName());

        data.put("profile", userWithOutCred);
        data.put("valute", valuteService.getAllValutes());
        data.put("history", historyService.getFullHistoryByUserId(user.getLogin()));
        data.put("roles", user.getRoles());


        model.addAttribute("frontendData", data);
        model.addAttribute("isDevMode", true);
        return "valuteView.html";

    }



}
