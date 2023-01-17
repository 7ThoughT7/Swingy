package swingy.services;

import swingy.models.Hero;

public interface HeroService {

    void addHero(String nameHero, String typeClass, String typeArtifact);
    void addCoordinate(Hero hero);
}
