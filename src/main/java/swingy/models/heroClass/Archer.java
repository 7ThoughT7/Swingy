package swingy.models.heroClass;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("archerType")
public class Archer extends TypeHero implements HeroClass{

    public Archer() {
        setNameClass("Archer");
        setAttack(15);
        setDefence(5);
        setHitPoint(100);
    }
}
