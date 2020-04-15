package entities.player;

public enum RaceType {
  ELF("Elf") {
    @Override
    public void specialCast() {
      System.out.println("Elf special magic spell!");
    }

    @Override
    public String getDescription() {
      return "description";
    }
  },
  DWARF("Dwarf") {
    @Override
    public void specialCast() {
      System.out.println("Dwarf special spell!");
    }

    @Override
    public String getDescription() {
      return "description";
    }
  },
  HUMAN("Human") {
    @Override
    public void specialCast() {
      System.out.println("Human special spell!");
    }

    @Override
    public String getDescription() {
      return "description";
    }
  },
  HIGHELF("High Elf") {
    @Override
    public void specialCast() {
      System.out.println("Human special spell!");
    }

    @Override
    public String getDescription() {
      return "description";
    }
  },
  MOUNTAINDWARF("Mountain Dwarf") {
    @Override
    public void specialCast() {
      System.out.println("Mountain Dwarf special spell!");
    }

    @Override
    public String getDescription() {
      return "description";
    }
  },
  ORC("Orc") {
    @Override
    public void specialCast() {
      System.out.println("Orc special spell!");
    }

    @Override
    public String getDescription() {
      return "description";
    }
  };

  private final String raceType;

  RaceType(String raceType) {
    this.raceType = raceType;
  }

  public abstract void specialCast();

  public abstract String getDescription();

  @Override
  public String toString() {
    return raceType;
  }
}
