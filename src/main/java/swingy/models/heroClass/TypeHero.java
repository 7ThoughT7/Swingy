package swingy.models.heroClass;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import swingy.models.Hero;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "typeHero")
public class TypeHero {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    private String nameClass;
    private Integer attack;
    private Integer defence;
    private Integer hitPoint;

    @OneToOne(mappedBy = "typeHero")
    private Hero hero;


}
