package entities.monster;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public abstract class Monster {
  private final IntegerProperty    hp = new SimpleIntegerProperty(); // health
  private final int phyDef; // Defense against physical damage
  private final int magDef; // Same but magical
  private final int expPer; // experience per killed monster

  public Monster(int hp, int phyDef, int magDef, int expPer) {
    this.hp.set(hp);
    this.phyDef = phyDef;
    this.magDef = magDef;
    this.expPer = expPer;
  }

  // Basic attacks damage calculated based on the
  // roll2Dice() method from DiceAction class
  // Each type of monster has its own dice
  public abstract int basicPhysAttack();

  public abstract int basicMagAttack();

  // TODO: Special attack
  // public abstract void specialAttack();

  public boolean isDead() {
    return getHp() < 0;
  }

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
    return hp.get();
  }

  public String getName() {
    return this.getClass().getSimpleName();
  }

  public IntegerProperty hpProperty() {
    return hp;
  }

  public void setHp(int dmg) {
    hp.set(getHp() - dmg);
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
