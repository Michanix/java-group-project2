package entities.monster;

// TODO: should it be Enum ? or maybe Interface?

public abstract class Monster {
  private int           hp; // health
  private final int phyDef; // Defense against physical damage
  private final int magDef; // Same but magical
  private final int expPer; // experience per killed monster

  public Monster(int hp, int phyDef, int magDef, int expPer) {
    this.hp     =     hp;
    this.phyDef = phyDef;
    this.magDef = magDef;
    this.expPer = expPer;
  }

  // Basic attacks damage calculated based on the
  // roll2Dice() method from DiceAction class
  // Each type of monster has its own dice
  public abstract int basicPhysAttack();

  public abstract int basicMagAttack();

  // Special attack
  public abstract void specialAttack();

  @Override
  public String toString() {
    return "Monster{"
        + "type="
        + getClass().getSimpleName()
        + ", hp="
        + hp
        + ", phyDef="
        + phyDef
        + ", magDef="
        + magDef
        + ", expPer="
        + expPer
        + '}';
  }

  // getters, setters
  public int getHp() {
    return hp;
  }

  public void setHp(int dmg) {
    this.hp -= dmg;
  }

  public int getPhyDef() {
    return phyDef;
  }

  public int getMagDef() {
    return magDef;
  }

  public int getExpPer() {
    return expPer;
  }
}
