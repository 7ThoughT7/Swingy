package swingy.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import swingy.models.artifacts.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "hr")
public class Hero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "heroId")
    private Integer id;

    private String name;
    private String heroClass;
    private Integer level;
    private Integer expirience;
    private Integer attack;
    private Integer defence;
    private Integer hitPoint;
    private Integer hitPointMax;
    private Integer potion30;
    private Integer potion50;
    private Integer coordinateX;
    private Integer coordinateY;
    private Integer sizeMap;

//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "userId")
//    private User user;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "armor_id", referencedColumnName = "id")
    private Armor armor;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "helm_id", referencedColumnName = "id")
    private Helm helm;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "weapon_id", referencedColumnName = "id")
    private Weapon weapon;

//    @OneToMany(fetch = FetchType.EAGER)
//    private Set<Equipment> equipments = new HashSet<>();

//    public void setEquipments(Equipment equipment) {
//        equipments.add(equipment);
//    }

//    public Hero(BuilderHero builder) {
//        this.name = builder.name;
//        this.heroClass = builder.heroClass;
//        this.level = builder.level;
//        this.expirience = builder.expirience;
//        this.attack = builder.attack;
//        this.defence = builder.defence;
//        this.hitPoint = builder.hitPoint;
//
//    }
//
//    public static class BuilderHero {
//        private final String name;
//        private final String heroClass;
//        private Integer level;
//        private Integer expirience;
//        private Integer attack;
//        private Integer defence;
//        private Integer hitPoint;
//
//        public BuilderHero(String name, String heroClass) {
//            this.name = name;
//            this.heroClass = heroClass;
//        }
//
//        public BuilderHero level(Integer level) {
//            this.level = level;
//            return this;
//        }
//
//        public BuilderHero expirience(Integer expirience) {
//            this.expirience = expirience;
//            return this;
//        }
//
//        public BuilderHero attack(Integer attack) {
//            this.attack = attack;
//            return this;
//        }
//
//        public BuilderHero defence(Integer defence) {
//            this.defence = defence;
//            return this;
//        }
//
//        public BuilderHero hitPoint(Integer hitPoint) {
//            this.hitPoint = hitPoint;
//            return this;
//        }
//
//        public Hero build() {
//            return new Hero(this);
//        }
//    }




}
