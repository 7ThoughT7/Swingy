package swingy.services.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import swingy.models.Hero;
import swingy.models.artifacts.Armor;
import swingy.models.artifacts.Helm;
import swingy.models.artifacts.Weapon;
import swingy.repos.HeroRepo;
import swingy.services.serviceRepo.HeroService;

@RequiredArgsConstructor
@Component
public class HeroServiceImpl implements HeroService {

    private final HeroRepo heroRepo;

    @Override
    public void addHero(String nameHero, String heroClass, String typeArtifact) {

        Hero hero = null;
        if (heroClass.equals("Archer")) {
            hero = buildHero(
                    nameHero, "Лучник", 15, 5, 100, 100
            );
        } else if (heroClass.equals("Berserk")) {
            hero = buildHero(
                    nameHero, "Воин", 10, 10, 130, 130
            );
        } else if (heroClass.equals("Wizard")) {
            hero = buildHero(
                    nameHero, "Маг", 20, 5, 80, 80
            );
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

    public Hero buildHero(String nameHero, String heroClass, Integer attack,
                      Integer defence, Integer hitPoint, Integer hitPointMax
    ) {
        return Hero.builder()
                .name(nameHero)
                .heroClass(heroClass)
                .level(1)
                .expirience(0)
                .attack(attack)
                .defence(defence)
                .hitPoint(hitPoint)
                .hitPointMax(hitPointMax)
                .potion30(2)
                .potion50(1)
                .build();
    }

    @Override
    public void addCoordinate(Hero hero) {
        hero.setSizeMap(((hero.getLevel() - 1) * 5 + 10) % 2 == 0 ? (hero.getLevel() - 1) * 5 + 9 : (hero.getLevel() - 1) * 5 + 10);
        hero.setCoordinateX(hero.getSizeMap() / 2 + 1);
        hero.setCoordinateY(hero.getSizeMap() / 2 + 1);
    }

    @Override
    public void healing(Hero hero, Integer health) {
        if (hero.getHitPoint() < hero.getHitPointMax()) {
            hero.setHitPoint(
                    (hero.getHitPoint() + health) > hero.getHitPointMax() ?
                            hero.getHitPointMax() : hero.getHitPoint() + health
            );
        }
        if (health == 50) {
            hero.setPotion50(hero.getPotion50() - 1);
        } else if (health == 30) {
            hero.setPotion30(hero.getPotion30() - 1);
        }
        heroRepo.save(hero);
    }
}
