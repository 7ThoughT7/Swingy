package swingy.models.artifacts;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("weaponType")
public class Weapon extends Equipment implements Artifact{

    public Weapon() {
        setNameArtifact("Weapon");
        setAttack(5);
        setDefence(0);
        setHitPoint(0);
    }
}
