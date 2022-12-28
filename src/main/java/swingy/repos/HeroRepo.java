package swingy.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import swingy.models.Hero;
import swingy.models.User;

public interface HeroRepo extends JpaRepository<Hero, Integer> {

    Hero findHeroById(Integer id);
}
