package swingy.models.artifacts;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("armorType")
public class Armor extends Equipment implements Artifact{

    public Armor() {
        setNameArtifact("Armor");
        setAttack(0);
        setDefence(5);
        setHitPoint(0);
    }
}
