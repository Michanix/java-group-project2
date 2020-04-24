package utils;

import entities.player.DiceType;

public class DiceAction {
  public static int roll2Dices(DiceType dice) {
    // method to calculate the outcome of the n dices rolled percentile vice
    // eg. Usually rolled 2 D10 -> First D10 shows 7 and Second 1
    // based on that the overall percantage calculated -> 71%
    int firstDigit = dice.rollTheDie();
    int secondDigit = dice.rollTheDie();
    int total = Integer.valueOf(String.valueOf(firstDigit) + String.valueOf(secondDigit));
    return total;
  }
}
