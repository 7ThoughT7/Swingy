package swingy.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import swingy.repos.HeroRepo;
import swingy.repos.UserRepo;

import java.util.Map;

@RequiredArgsConstructor
@Controller
public class MainController {

    private final HeroRepo heroRepo;
    private final UserRepo userRepo;

    @GetMapping("/")
    public String greeting() {
        return "greeting";
    }

    @GetMapping("/main/{user_id}")
    public String main(@PathVariable Integer user_id, Model model) {
        model.addAttribute("heroes", heroRepo.findAll());
        return "/main";
    }
}
