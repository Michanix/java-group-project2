package entities.monster;

import entities.player.DiceType;
import utils.DiceAction;

/*
Troll is very strong physically, but lacks magical abilities.
 */

public class Troll extends Monster {

  public Troll(
          int hp, int phyDef,
          int magDef, int expPer) {
    super(hp, phyDef, magDef, expPer);
  }

  @Override
  public int basicPhysAttack() {
    return DiceAction.roll2Dices(DiceType.D8);
  }

  @Override
  public int basicMagAttack() {
    return DiceAction.roll2Dices(DiceType.D4);
  }

  @Override
  public String toString() {
    return super.toString();
  }
}
