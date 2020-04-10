package entities;

public enum DiceType {
  D4("D4") {
    public int sides() {
      return 4;
    }
  },
  D6("D6") {
    public int sides() {
      return 6;
    }
  },
  D8("D8") {
    public int sides() {
      return 8;
    }
  },
  D10("D10") {
    public int sides() {
      return 10;
    }
  },
  D12("D12") {
    public int sides() {
      return 12;
    }
  },
  D20("D20") {
    public int sides() {
      return 20;
    }
  };

  private final String diceName;

  DiceType(String diceName) {
    this.diceName = diceName;
  }

  public abstract int sides();

  @Override
  public String toString() {
    return diceName;
  }
}