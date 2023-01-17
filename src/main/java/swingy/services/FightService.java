package swingy.services;

import swingy.models.Hero;

public interface FightService {

    void changePosition(Hero hero, String way);

    boolean checkWin(Hero hero);
}
