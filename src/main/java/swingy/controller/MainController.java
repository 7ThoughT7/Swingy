package swingy.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/main")
    public String main(Model model) {
        model.addAttribute("heroes", heroRepo.findAll());
        return "/main";
    }

    @PostMapping("/main")
    public String createHero() {
        return "redirect:/createHero";
    }
}
