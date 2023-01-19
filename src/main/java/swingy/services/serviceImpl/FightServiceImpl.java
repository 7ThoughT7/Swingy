package swingy.services.serviceImpl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import swingy.models.Hero;
import swingy.models.artifacts.Armor;
import swingy.models.artifacts.Helm;
import swingy.models.artifacts.Weapon;
import swingy.models.monster.Monster;
import swingy.repos.HeroRepo;
import swingy.repos.MonsterRepo;
import swingy.services.serviceRepo.FightService;

@RequiredArgsConstructor
@Component
public class FightServiceImpl implements FightService {

    private final HeroRepo heroRepo;
    private final MonsterRepo monsterRepo;


    @Override
    public void changePosition(Hero hero, String way) {
        if (way.equals("Up")) {
            hero.setCoordinateX(hero.getCoordinateX() - 1);
            heroRepo.save(hero);
        } else if (way.equals("Left")) {
            hero.setCoordinateY(hero.getCoordinateY() - 1);
            heroRepo.save(hero);
        } else if (way.equals("Right")) {
            hero.setCoordinateY(hero.getCoordinateY() + 1);
            heroRepo.save(hero);
        } else if (way.equals("Down")) {
            hero.setCoordinateX(hero.getCoordinateX() + 1);
            heroRepo.save(hero);
        }
    }

    @Override
    public boolean checkWin(Hero hero) {

        if (hero.getCoordinateX() <= 1 || hero.getCoordinateY() <= 1 ||
            hero.getCoordinateX() >= hero.getSizeMap() || hero.getCoordinateY() >= hero.getSizeMap()
        ) {
            return true;
        }

        return false;
    }

    @Override
    public void attack(Hero hero, Monster monster) {
        hero.setHitPoint(hero.getHitPoint() - (monster.getAttack() - hero.getDefence()));
        heroRepo.save(hero);
        monster.setHitPoint(monster.getHitPoint() - (hero.getAttack() - monster.getDefence()));
        monsterRepo.save(monster);
    }

    @Override
    public void nextStep(Hero hero, Monster monster) {
        hero.setHitPoint(hero.getHitPoint() - (monster.getAttack() - hero.getDefence()));
        heroRepo.save(hero);
    }

    @Override
    public void saveEquip(Hero hero, String equip) {
        if (equip.equals("Armor")) {
            if (hero.getArmor() != null) {
                hero.setDefence(hero.getDefence() - hero.getArmor().getDefence());
            }
            Armor armor = new Armor(hero.getLevel());
            hero.setArmor(armor);
            hero.setDefence(hero.getDefence() + armor.getDefence());
        } else if (equip.equals("Helm")) {
            if (hero.getHelm() != null) {
                hero.setHitPoint(hero.getHitPoint() - hero.getHelm().getHitPoint());
            }
            Helm helm = new Helm(hero.getLevel());
            hero.setHelm(helm);
            hero.setHitPoint(hero.getHitPoint() + helm.getHitPoint());
        } else if (equip.equals("Weapon")) {
            if (hero.getWeapon() != null) {
                hero.setAttack(hero.getAttack() - hero.getWeapon().getAttack());
            }
            Weapon weapon = new Weapon(hero.getLevel());
            hero.setWeapon(weapon);
            hero.setAttack(hero.getAttack() + weapon.getAttack());
        }
        heroRepo.save(hero);
    }
}
