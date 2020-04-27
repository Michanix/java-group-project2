package entities.monster;

import entities.player.DiceType;
import utils.DiceAction;

public abstract class Monster {
  private final int         hp; // health
  private final double  phyDef; // Defense against physical damage
  private final double  magDef; // Same but magical
  private final int     expPer; // experience per killed monster

  public Monster(
          int hp, double phyDef,
          double magDef, int expPer) {
    this.hp     =     hp;
    this.phyDef = phyDef;
    this.magDef = magDef;
    this.expPer = expPer;
  }

  // Basic attack depends on the outcome of D4 dice
  public int basicPhysAttack() {
    return DiceAction.roll2Dices(DiceType.D4);
  };

  public int basicMagAttack() {
    return DiceAction.roll2Dices(DiceType.D6);
  }
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

  // getters
  public int getHp() {
    return hp;
  }

  public double getPhyDef() {
    return phyDef;
  }

  public double getMagDef() {
    return magDef;
  }

  public int getExpPer() {
    return expPer;
  }
}
