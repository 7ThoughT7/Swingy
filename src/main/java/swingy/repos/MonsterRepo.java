package swingy.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import swingy.models.Hero;
import swingy.models.monster.Monster;

public interface MonsterRepo extends JpaRepository<Monster, Integer> {

    Monster findMonsterById(Integer id);
}
