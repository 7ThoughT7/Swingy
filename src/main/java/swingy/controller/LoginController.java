package swingy.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import swingy.forms.LoginForm;
import swingy.services.serviceRepo.LoginService;

@RequiredArgsConstructor
@Controller
@RequestMapping("/login")
public class LoginController {

    private final LoginService loginService;

    @GetMapping
    public String getLoginPage() {
        return "/login";
    }

    @PostMapping
    public String authentication(LoginForm form) {

        if (loginService.loginUser(form)) {

            return "redirect:/main";
        }
        return "redirect:/login";
    }

}
