package swingy.models.heroClass;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("berserkType")
public class Berserk extends TypeHero implements HeroClass{

    public Berserk() {
        setNameClass("Berserk");
        setAttack(10);
        setDefence(10);
        setHitPoint(130);
    }
}
