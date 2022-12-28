package swingy.models.artifacts;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import swingy.models.Hero;


@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "equip")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "art")
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    private String nameArtifact;
    private Integer attack;
    private Integer defence;
    private Integer hitPoint;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "heroId")
    private Hero hero;

    public String getNameArtifact() {
        return nameArtifact;
    }

    public void setNameArtifact(String nameArtifact) {
        this.nameArtifact = nameArtifact;
    }

    public Integer getAttack() {
        return attack;
    }

    public void setAttack(Integer attack) {
        this.attack = attack;
    }

    public Integer getDefence() {
        return defence;
    }

    public void setDefence(Integer defence) {
        this.defence = defence;
    }

    public Integer getHitPoint() {
        return hitPoint;
    }

    public void setHitPoint(Integer hitPoint) {
        this.hitPoint = hitPoint;
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }
}
