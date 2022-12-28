package swingy.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import swingy.models.Hero;
import swingy.models.artifacts.Equipment;

public interface EquipmentRepo extends JpaRepository<Equipment, Integer> {
}
