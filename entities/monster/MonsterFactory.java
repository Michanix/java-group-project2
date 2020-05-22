package entities.monster;

public class MonsterFactory {
    public Monster createMonster(MonsterType monsterType) {
        switch (monsterType) {
            case TROLL:
                return new Troll(2000, 45, 20, 75);
            case GODDESS:
                return new Goddess(400, 60, 80, 150);
            default:
                return null;
        }
    }
}
