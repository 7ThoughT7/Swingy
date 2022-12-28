package swingy.models;


import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "usr")
public class User{

    public enum Role {
        ADMIN, USER
    }

    public enum HClass {
        ARCHER, BERSERK, WIZARD
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String username;
    private String email;
    private String password;

    @Enumerated(value = EnumType.STRING)
    private Role role;

    @Enumerated(value = EnumType.STRING)
    private HClass hClass;

    @OneToMany(fetch = FetchType.EAGER)
    private Set<Hero> heroes;
}
