package swingy.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import swingy.models.Hero;
import swingy.repos.HeroRepo;

@RequiredArgsConstructor
@Component
public class FightServiceImpl implements FightService{

    private final HeroRepo heroRepo;


    @Override
    public void changePosition(Hero hero, String way) {
        if (way.equals("Up")) {
            hero.setCoordinateX(hero.getCoordinateX() - 1);
            heroRepo.save(hero);
        } else if (way.equals("Left")) {
            hero.setCoordinateY(hero.getCoordinateY() - 1);
            heroRepo.save(hero);
        } else if (way.equals("Right")) {
            hero.setCoordinateY(hero.getCoordinateY() + 1);
            heroRepo.save(hero);
        } else if (way.equals("Down")) {
            hero.setCoordinateX(hero.getCoordinateX() + 1);
            heroRepo.save(hero);
        }
    }

    @Override
    public boolean checkWin(Hero hero) {

        if (hero.getCoordinateX() <= 1 || hero.getCoordinateY() <= 1 ||
            hero.getCoordinateX() >= hero.getSizeMap() || hero.getCoordinateY() >= hero.getSizeMap()
        ) {
            return true;
        }

        return false;
    }


}
