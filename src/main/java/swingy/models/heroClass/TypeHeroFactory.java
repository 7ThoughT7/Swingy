package swingy.models.heroClass;

public class TypeHeroFactory {

    public static HeroClass newTypeHero(String type) {

        String ARCHER = "Archer";
        String BERSERK = "Berserk";
        String WIZARD = "Wizard";

        if (type.equals(ARCHER)) {
            return new Archer();
        } else if (type.equals(BERSERK)) {
            return new Berserk();
        } else if (type.equals(WIZARD)) {
            return new Wizard();
        }
        return null;
    }
}
