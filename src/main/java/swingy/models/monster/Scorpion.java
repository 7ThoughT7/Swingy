package swingy.models.monster;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("scorpionType")
public class Scorpion extends Monster implements Enemy{

    public Scorpion(Integer level) {
        setName("Scorpion");
        setLevel(level);
        setAttack(15 + level);
        setDefence(5 + level);
        setHitPoint(60 + (level * level));
    }

    public Scorpion() {

    }
}
