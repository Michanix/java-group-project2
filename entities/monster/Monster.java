package entities.monster;

public abstract class Monster {
  private final int         hp; // health
  private final double  phyDmg; // Physical damage
  private final double  magDmg; // Magical damage
  private final double  phyDef; // Defense against physical damage
  private final double  magDef; // Same but magical
  private final int     expPer; // experience per killed monster

  public Monster(int hp, double phyDmg, double magDmg,
                 double phyDef, double magDef, int expPer) {
    this.hp =         hp;
    this.phyDmg = phyDmg;
    this.magDmg = magDmg;
    this.phyDef = phyDef;
    this.magDef = magDef;
    this.expPer = expPer;
  }

  // Ordinary hit
  public abstract void attack();
  // Special attack
  public abstract void specialAttack();

  @Override
  public String toString() {
    return "Monster{"
        + "type="
        + getClass().getSimpleName()
        + ", hp="
        + hp
        + ", phyDmg="
        + phyDmg
        + ", magDmg="
        + magDmg
        + ", phyDef="
        + phyDef
        + ", magDef="
        + magDef
        + ", expPer="
        + expPer
        + '}';
  }
}
