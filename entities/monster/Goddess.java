package entities.monster;

import entities.player.DiceType;
import utils.DiceAction;

/*
Goddess has very strong physical abilities as well as magical
 */

public class Goddess extends Monster {

  public Goddess(
          int hp, int phyDef,
          int magDef, int expPer) {
    super(hp, phyDef, magDef, expPer);
  }

  @Override
  public int basicPhysAttack() {
    return DiceAction.roll2Dices(DiceType.D6);
  }

  @Override
  public int basicMagAttack() {
    return DiceAction.roll2Dices(DiceType.D8);
  }

  @Override
  public void specialAttack() {
    System.out.println("Goddess special attack");
  }

  @Override
  public String toString() {
    return super.toString();
  }
}
