package utils;

import entities.player.DiceType;

public class DiceAction {
  public static int roll2Dices(DiceType dice) {
    // method to calculate the outcome of the n dices rolled percentile vice
    // eg. Rolled 2 dices -> First die shows 7 and second shows 1
    // based on that the overall percentile calculated -> 71%
    int firstDigit = dice.rollTheDie();
    int secondDigit = dice.rollTheDie();
    return Integer.parseInt(String.valueOf(firstDigit) + String.valueOf(secondDigit));
  }
}
