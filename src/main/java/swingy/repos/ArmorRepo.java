package swingy.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import swingy.models.artifacts.Armor;

public interface ArmorRepo extends JpaRepository<Armor, Integer> {
}
