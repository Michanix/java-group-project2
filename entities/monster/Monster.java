package entities.monster;

import entities.player.DiceType;
import utils.DiceAction;

// TODO: turn into interface

public abstract class Monster {
  private int               hp; // health
  private final int     phyDef; // Defense against physical damage
  private final int     magDef; // Same but magical
  private final int     expPer; // experience per killed monster

  public Monster(
          int hp, int phyDef,
          int magDef, int expPer) {
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

  public void setHp(int dmg) {
    this.hp -= dmg;
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
