package swingy.services;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import swingy.models.Hero;
import swingy.models.artifacts.Armor;
import swingy.models.artifacts.Helm;
import swingy.models.artifacts.Weapon;
import swingy.repos.HeroRepo;

@RequiredArgsConstructor
@Component
public class HeroServiceImpl implements HeroService{

    private final HeroRepo heroRepo;

    @Override
    public void addHero(String nameHero, String heroClass, String typeArtifact) {

        Hero hero = null;
        if (heroClass.equals("Archer")) {
            hero = Hero.builder()
                    .name(nameHero)
                    .heroClass("Лучник")
                    .level(1)
                    .expirience(0)
                    .attack(15)
                    .defence(5)
                    .hitPoint(100)
                    .build();
        } else if (heroClass.equals("Berserk")) {
            hero = Hero.builder()
                    .name(nameHero)
                    .heroClass("Воин")
                    .level(1)
                    .expirience(0)
                    .attack(10)
                    .defence(10)
                    .hitPoint(130)
                    .build();
        } else if (heroClass.equals("Wizard")) {
            hero = Hero.builder()
                    .name(nameHero)
                    .heroClass("Маг")
                    .level(1)
                    .expirience(0)
                    .attack(20)
                    .defence(5)
                    .hitPoint(80)
                    .build();
        }
        if (hero != null) {
            addCoordinate(hero);
            if (typeArtifact.equals("Armor")) {
                Armor armor = new Armor();
                hero.setArmor(armor);
                hero.setDefence(hero.getDefence() + armor.getDefence());
            } else if (typeArtifact.equals("Helm")) {
                Helm helm = new Helm();
                hero.setHelm(helm);
                hero.setHitPoint(hero.getHitPoint() + helm.getHitPoint());
            } else if (typeArtifact.equals("Weapon")) {
                Weapon weapon = new Weapon();
                hero.setWeapon(weapon);
                hero.setAttack(hero.getAttack() + weapon.getAttack());
            }
            heroRepo.save(hero);
        }
    }

    @Override
    public void addCoordinate(Hero hero) {
        hero.setSizeMap(((hero.getLevel() - 1) * 5 + 10) % 2 == 0 ? (hero.getLevel() - 1) * 5 + 9 : (hero.getLevel() - 1) * 5 + 10);
        hero.setCoordinateX(hero.getSizeMap() / 2 + 1);
        hero.setCoordinateY(hero.getSizeMap() / 2 + 1);
    }
}
