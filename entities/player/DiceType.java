package entities.player;

/*
Enum to represent different dice types
like 4 sided, 6 sided and so on.
Any new types of dice should be added here.
 */

public enum DiceType {
  D4("D4", 4),
  D6("D6", 6),
  D8("D8", 8),
  D10("D10", 10),
  D12("D12", 12),
  D20("D20", 20);

  private final String diceName;
  private final int       sides;

  DiceType(String diceName, int sides) {
    this.diceName = diceName;
    this.sides    =    sides;
  }

  public int getSides() {
    return sides;
  }

  public int rollTheDie() {
    return 1 + (int) (Math.random() * (getSides() - 1) + 1);
  }

  @Override
  public String toString() {
    return diceName;
  }
}
