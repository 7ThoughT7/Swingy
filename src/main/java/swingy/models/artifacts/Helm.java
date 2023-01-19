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
public class Helm{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    private String nameArtifact;
    private Integer attack;
    private Integer defence;
    private Integer hitPoint;

    @OneToOne(mappedBy = "helm")
    private Hero hero;

    public Helm() {
        this.nameArtifact = "Шлем";
        this.attack = 0;
        this.defence = 0;
        this.hitPoint = 5;
    }

    public Helm(Integer level) {
        this.nameArtifact = "Шлем";
        this.attack = level;
        this.defence = 0;
        this.hitPoint = 5 * level;
    }
}
