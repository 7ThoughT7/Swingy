package swingy.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import swingy.models.Hero;
import swingy.repos.HeroRepo;
import swingy.services.serviceRepo.HeroService;

@RequiredArgsConstructor
@Controller
//@RequestMapping("/createHero")
public class HeroController {

    private final HeroService heroService;
    private final HeroRepo heroRepo;

    @GetMapping("/createHero")
    public String createHero() {

//        User user = userRepo.findUserById(userId);
//        model.addAttribute("user", user);
//        model.addAttribute("HClass", user.getHClass());

        return "/createHero";
    }

    @PostMapping("/createHero")
    public String addCreateHero(@RequestParam String nameHero,
                                @RequestParam String typeClass,
                                @RequestParam String typeArtifact) {

        if (typeClass != null && typeArtifact != null) {
            heroService.addHero(nameHero, typeClass, typeArtifact);
            return "redirect:/main";
        }
        return "redirect:/createHero";
    }

    @GetMapping("/hero/{heroId}")
    public String mainHero(Model model,
                           @PathVariable Integer heroId
    ) {
        model.addAttribute("hero", heroRepo.findHeroById(heroId));
        return "/hero";
    }

    @PostMapping("/hero/{heroId}")
    public String fighting(@PathVariable Integer heroId,
                           @RequestParam String heroButton
    ) {

        Hero hero = heroRepo.findHeroById(heroId);

        if (heroButton.equals("Fight")) {
            if (hero.getHitPoint() <= 0) {
                return "redirect:/hero/{heroId}";
            } else {
                heroService.addCoordinate(hero);
                heroRepo.save(hero);
                return "redirect:/fight/{heroId}";
            }
        } else if (heroButton.equals("50")) {
            if (hero.getPotion50() > 0) {
                heroService.healing(hero, 50);
            }
        } else if (heroButton.equals("30")) {
            if (hero.getPotion30() > 0) {
                heroService.healing(hero, 30);
            }
        }

        return "redirect:/hero/{heroId}";
    }
}
