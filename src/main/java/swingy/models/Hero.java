package swingy.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import swingy.models.artifacts.Equipment;
import swingy.models.artifacts.EquipmentFactory;
import swingy.models.heroClass.TypeHero;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "hr")
public class Hero {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;

    private String name;
    private Integer level;
    private Integer expirience;
    private Integer attack;
    private Integer defence;
    private Integer hitPoint;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userId")
    private User user;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "typeHero_id", referencedColumnName = "id")
    private TypeHero typeHero;

    @OneToMany(fetch = FetchType.EAGER)
    private Set<Equipment> equipments = new HashSet<>();

    public void setEquipments(Equipment equipment) {
        equipments.add(equipment);
    }

    public Hero(String name, TypeHero typeHero, Equipment equipment) {
        this.level = 1;
        this.expirience = 0;
        this.name = name;
        this.typeHero = typeHero;
        this.attack = typeHero.getAttack();
        this.defence = typeHero.getDefence();
        this.hitPoint = typeHero.getHitPoint();
        setEquipments(equipment);

    }


//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "address_id", referencedColumnName = "id")
//    private Address address;
}
