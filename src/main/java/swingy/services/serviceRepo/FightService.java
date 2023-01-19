package swingy.services.serviceRepo;

import swingy.models.Hero;
import swingy.models.monster.Monster;

public interface FightService {

    void changePosition(Hero hero, String way);

    boolean checkWin(Hero hero);

    void attack(Hero hero, Monster monster);

    void nextStep(Hero hero, Monster monster);

    void saveEquip(Hero hero, String equip);
}
