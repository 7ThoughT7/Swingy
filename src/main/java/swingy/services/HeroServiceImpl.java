package swingy.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import swingy.forms.HeroForm;
import swingy.models.Hero;
import swingy.models.heroClass.Archer;
import swingy.models.heroClass.TypeHero;
import swingy.repos.HeroRepo;

import java.util.Objects;

@RequiredArgsConstructor
@Component
public class HeroServiceImpl implements HeroService{

    private final HeroRepo heroRepo;

    @Override
    public void addHero(String nameHero, String typeClass) {
        TypeHero typeHero = null;
        if (Objects.equals(typeClass, "Archer")) {
            typeHero = new Archer();
        }
        Hero hero = new Hero(nameHero, typeHero);
        heroRepo.save(hero);
    }
}
