package swingy.controller;

import ch.qos.logback.core.sift.AppenderFactoryUsingSiftModel;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import swingy.models.Hero;
import swingy.models.monster.Monster;
import swingy.models.monster.MonsterFactory;
import swingy.repos.HeroRepo;
import swingy.repos.MonsterRepo;
import swingy.services.FightService;
import swingy.services.MonsterService;

import java.util.Random;

@RequiredArgsConstructor
@Controller
public class FightController {

    private final HeroRepo heroRepo;
    private final MonsterRepo monsterRepo;
    private final FightService fightService;
    private final MonsterService monsterService;

    @GetMapping("/fight/{heroId}")
    public String fight(Model model,
                        @PathVariable Integer heroId
    ) {
        model.addAttribute("hero", heroRepo.findHeroById(heroId));
        return "/fight";
    }

    @PostMapping("/fight/{heroId}")
    public String click(@PathVariable Integer heroId,
                        @RequestParam String way) {

        Random random = new Random();
        Hero hero = heroRepo.findHeroById(heroId);
        fightService.changePosition(hero, way);
        if (fightService.checkWin(hero)) {
            return "redirect:/fightWin/{heroId}";
        }
        if (random.nextInt(4) == 3) {
            return "redirect:/attackMonster/{heroId}";
        }
        return "redirect:/fight/{heroId}";
    }

    @GetMapping("/fightWin/{heroId}")
    public String fightWin(Model model,
                           @PathVariable Integer heroId
    ) {
        model.addAttribute("hero", heroRepo.findHeroById(heroId));
        return "/fightWin";
    }

    @GetMapping("/attackMonster/{heroId}")
    public String attackMonsterGet(Model model,
                                   @PathVariable Integer heroId
    ) {
        Hero hero = heroRepo.findHeroById(heroId);
        model.addAttribute("hero", hero);
        Monster monster = MonsterFactory.newMonster(hero.getLevel());
        if (monster != null) {
            monsterRepo.save(monster);
            model.addAttribute("monster", monster);
        }

        return "/attackMonster";
    }

    @PostMapping("/attackMonster/{heroId}/{monsterId}")
    public String attackMonsterPost(@PathVariable Integer heroId,
                                    @PathVariable Integer monsterId,
                                    @RequestParam String fight
                                    ) {
        if (fight.equals("Fight")) {
            return "redirect:/fightMonster/{heroId}/{monsterId}";
        } else if (fight.equals("Run")) {
            Random random = new Random();
            if (random.nextBoolean()) {
                return "redirect:/fight/{heroId}";
            } else {
                return "redirect:/fightMonster/{heroId}/{monsterId}";
            }
        }
        return "redirect:/attackMonster/{heroId}/{monsterId}";
    }

    @GetMapping("/fightMonster/{heroId}/{monsterId}")
    public String fightMonsterGet(Model model,
                                  @PathVariable Integer heroId,
                                  @PathVariable Integer monsterId
    ) {

        model.addAttribute("hero", heroRepo.findHeroById(heroId));
        model.addAttribute("monster", monsterRepo.findMonsterById(monsterId));
        return "/fightMonster";
    }

    @PostMapping("/fightMonster/{heroId}/{monsterId}")
    public String fightMonsterPost(@PathVariable Integer heroId,
                                   @PathVariable Integer monsterId,
                                   @RequestParam String attack
    ) {
        Hero hero = heroRepo.findHeroById(heroId);
        Monster monster = monsterRepo.findMonsterById(monsterId);
        if (attack.equals("Attack")) {
            hero.setHitPoint(hero.getHitPoint() - (monster.getAttack() - hero.getDefence()));
            heroRepo.save(hero);
            monster.setHitPoint(monster.getHitPoint() - (hero.getAttack() - monster.getDefence()));
            monsterRepo.save(monster);
            if (hero.getHitPoint() <= 0) {
                return "redirect:/fightLose/{heroId}";
            } else if (monster.getHitPoint() <= 0) {
                return "redirect:/fightWin/{heroId}";
            }
        } else if (attack.equals("Next")) {
            hero.setHitPoint(hero.getHitPoint() - (monster.getAttack() - hero.getDefence()));
            heroRepo.save(hero);
            if (hero.getHitPoint() <= 0) {
                return "redirect:/fightLose/{heroId}";
            } else if (monster.getHitPoint() <= 0) {
                return "redirect:/fightWin/{heroId}";
            }
        }

        return "redirect:/fightMonster/{heroId}/{monsterId}";
    }

    @GetMapping("/fightLose/{heroId}")
    public String fightLose(Model model,
                           @PathVariable Integer heroId
    ) {
        model.addAttribute("hero", heroRepo.findHeroById(heroId));
        return "/fightWin";
    }
}
