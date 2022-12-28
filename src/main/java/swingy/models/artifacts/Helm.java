package swingy.models.artifacts;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;

@Entity
@DiscriminatorValue("helmType")
public class Helm extends Equipment implements Artifact{

    public Helm() {
        setNameArtifact("Helm");
        setAttack(0);
        setDefence(0);
        setHitPoint(5);
    }
}
