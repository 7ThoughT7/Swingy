package swingy.models.artifacts;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import swingy.models.Hero;

@Data
@AllArgsConstructor
@Builder
@Entity
@Table(name = "equip")
public class Armor{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    private String nameArtifact;
    private Integer attack;
    private Integer defence;
    private Integer hitPoint;

    @OneToOne(mappedBy = "armor")
    private Hero hero;

    public Armor() {
        this.nameArtifact = "Броня";
        this.attack = 0;
        this.defence = 5;
        this.hitPoint = 0;
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }
}
