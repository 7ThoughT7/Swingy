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
public class Weapon{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    private String nameArtifact;
    private Integer attack;
    private Integer defence;
    private Integer hitPoint;

    @OneToOne(mappedBy = "weapon")
    private Hero hero;

    public Weapon() {
        this.nameArtifact = "Оружие";
        this.attack = 5;
        this.defence = 0;
        this.hitPoint = 0;
    }

    public Weapon(Integer level) {
        this.nameArtifact = "Оружие";
        this.attack = 5 * level;
        this.defence = level;
        this.hitPoint = 0;
    }
}
