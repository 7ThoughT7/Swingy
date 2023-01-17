package swingy.models.monster;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("goblinType")
public class Goblin extends Monster implements Enemy{

    public Goblin(Integer level) {
        setName("Goblin");
        setLevel(level);
        setAttack(17 + level);
        setDefence(10 + level);
        setHitPoint(40 + (level * level));
    }

    public Goblin() {

    }
}
