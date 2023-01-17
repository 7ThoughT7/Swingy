package swingy.models.monster;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("spiderType")
public class Spider extends Monster implements Enemy{

    public Spider(Integer level) {
        setName("Spider");
        setLevel(level);
        setAttack(10 + level);
        setDefence(7 + level);
        setHitPoint(50 + (level * level));
    }

    public Spider() {

    }
}
