package swingy.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import swingy.forms.HeroForm;
import swingy.models.Hero;
import swingy.models.User;
import swingy.repos.HeroRepo;
import swingy.repos.UserRepo;
import swingy.services.HeroService;

import java.util.Map;
import java.util.Optional;

@RequiredArgsConstructor
@Controller
//@RequestMapping("/createHero")
public class HeroController {

    private final HeroService heroService;
    private final HeroRepo heroRepo;
    private final UserRepo userRepo;

    @GetMapping("/createHero")
    public String createHero(@RequestParam Integer userId, Model model) {

        User user = userRepo.findUserById(userId);
        model.addAttribute("user", user);
//        model.addAttribute("HClass", user.getHClass());

        return "/createHero";
    }

    @PostMapping("/createHero")
    public String addCreateHero(@RequestParam Integer userId,
                                @RequestParam String nameHero,
                                @RequestParam String typeClass) {

        heroService.addHero(nameHero, typeClass);

        return "redirect:/main/{user_id}";
    }
}
