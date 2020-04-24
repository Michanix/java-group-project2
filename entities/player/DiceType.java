package entities.player;

public enum DiceType {
  D4("D4") {
    public int sides() {
      return 4;
    }
    public int rollTheDie() {
      return (int) (Math.random() * sides());
    }
  },
  D6("D6") {
    public int sides() {
      return 6;
    }
    public int rollTheDie() {
      return (int) (Math.random() * sides());
    }
  },
  D8("D8") {
    public int sides() {
      return 8;
    }
    public int rollTheDie() {
      return (int) (Math.random() * sides());
    }
  },
  D10("D10") {
    public int sides() {
      return 10;
    }
    public int rollTheDie() {
      return (int) (Math.random() * sides());
    }
  },
  D12("D12") {
    public int sides() {
      return 12;
    }
    public int rollTheDie() {
      return (int) (Math.random() * sides());
    }
  },
  D20("D20") {
    public int sides() {
      return 20;
    }
    public int rollTheDie() {
      return (int) (Math.random() * sides());
    }
  };

  private final String diceName;

  DiceType(String diceName) {
    this.diceName = diceName;
  }

  public abstract int sides();

  public abstract int rollTheDie();

  @Override
  public String toString() {
    return diceName;
  }
}
