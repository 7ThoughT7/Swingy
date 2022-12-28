package swingy.models.heroClass;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("wizardType")
public class Wizard extends TypeHero implements HeroClass{

    public Wizard() {
        setNameClass("Wizard");
        setAttack(20);
        setDefence(5);
        setHitPoint(80);
    }
}
