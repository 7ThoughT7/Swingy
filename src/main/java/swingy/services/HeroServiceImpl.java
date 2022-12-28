package swingy.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import swingy.forms.HeroForm;
import swingy.models.Hero;
import swingy.models.artifacts.Equipment;
import swingy.models.artifacts.EquipmentFactory;
import swingy.models.heroClass.Archer;
import swingy.models.heroClass.HeroClass;
import swingy.models.heroClass.TypeHero;
import swingy.models.heroClass.TypeHeroFactory;
import swingy.repos.EquipmentRepo;
import swingy.repos.HeroRepo;
import swingy.repos.TypeHeroRepo;

import java.util.Objects;

@RequiredArgsConstructor
@Component
public class HeroServiceImpl implements HeroService{

    private final HeroRepo heroRepo;
    private final EquipmentRepo equipmentRepo;
    private final TypeHeroRepo typeHeroRepo;

    @Override
    public void addHero(String nameHero, String typeClass, String typeArtifact) {

        TypeHero typeHero = TypeHeroFactory.newTypeHero(typeClass);
        Equipment equipment = EquipmentFactory.newEquipment(typeArtifact);

        if (equipment != null && typeHero != null) {
            Hero hero = new Hero(nameHero, typeHero, equipment);
            
            heroRepo.save(hero);
        }
    }
}
