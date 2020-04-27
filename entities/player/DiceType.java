package entities.player;

public enum DiceType {
  D4("D4", 4) {},
  D6("D6", 6) {},
  D8("D8", 8) {},
  D10("D10", 10) {},
  D12("D12", 12) {},
  D20("D20", 20) {};

  private final String diceName;
  private final int sides;

  DiceType(String diceName, int sides) {
    this.diceName = diceName;
    this.sides = sides;
  }

  public int getSides() {
    return sides;
  }

  public int rollTheDie() {
    return (int) (Math.random() * getSides());
  }

  @Override
  public String toString() {
    return diceName;
  }
}
