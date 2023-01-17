package swingy.models.monster;

import swingy.models.heroClass.Archer;
import swingy.models.heroClass.Berserk;
import swingy.models.heroClass.Wizard;

import java.util.Random;

public class MonsterFactory {

    public static Monster newMonster(Integer level) {

        Random random = new Random();
        int typeMonster = random.nextInt(2);


        if (typeMonster == 0) {
            return new Spider(level);
        } else if (typeMonster == 1) {
            return new Scorpion(level);
        } else if (typeMonster == 2) {
            return new Goblin(level);
        }
        return null;
    }
}
