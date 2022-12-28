package swingy.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import swingy.models.heroClass.TypeHero;

public interface TypeHeroRepo extends JpaRepository<TypeHero, Integer> {
}
