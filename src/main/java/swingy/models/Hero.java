package swingy.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import swingy.models.heroClass.TypeHero;

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

//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "userId")
//    private User user;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "typeHero_id", referencedColumnName = "id")
    private TypeHero typeHero;

    public Hero(String name) {
        this.name = name;
    }

    public Hero(String name, TypeHero typeHero) {
        this.name = name;
        this.typeHero = typeHero;
    }


//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "address_id", referencedColumnName = "id")
//    private Address address;
}
