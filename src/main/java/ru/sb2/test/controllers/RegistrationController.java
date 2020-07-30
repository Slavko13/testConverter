package ru.sb2.test.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import ru.sb2.test.domains.Roles;
import ru.sb2.test.domains.Users;
import ru.sb2.test.domains.dto.CaptchaResponse;
import ru.sb2.test.services.UsersService;
import ru.sb2.test.utils.UserValidator;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

@Controller
public class RegistrationController {

    private final static String CAPTCHA_URL = "https://www.google.com/recaptcha/api/siteverify?secret=%s&response=%s";

    @Autowired
    private UsersService usersService;

    @Autowired
    private RestTemplate restTemplate;

    @Value("${recaptcha.secret}")
    private String secretKey;

    @GetMapping("/registration")
    public String showRegistrationForm() {
        return "registrationView";
    }

    @PostMapping("/registration")
    public String addUser(@ModelAttribute Users user, Model model,
    @RequestParam("g-recaptcha-response") String captcha, @RequestParam("Roles") Set<Roles> roles ) {


        String url = String.format(CAPTCHA_URL, secretKey, captcha);
        CaptchaResponse captchaResponse = restTemplate.postForObject(url, Collections.emptyList(), CaptchaResponse.class);


        if (!captchaResponse.isSuccess()) {
            model.addAttribute("error", "Заполните каптчу");
            return "registrationView";
        }



        boolean userInfo = usersService.addUser(user, roles);
        if (!userInfo) {
            model.addAttribute("haveErrors", true);
            model.addAttribute("error", "This login already exist");
            return "registrationView";
        }

        return "redirect:/login";
    }

    @GetMapping("/login")
    public String loginError(@RequestParam(name = "error", required = false) Boolean error, Model model) {
        if (Boolean.TRUE.equals(error)) {
            model.addAttribute("error", true);
        }
        return "loginView";
    }




}
