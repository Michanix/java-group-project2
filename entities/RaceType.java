package entities;

public enum RaceType {
  ELF("Elf") {
    @Override
    public void specialCast() {
      System.out.println("Elf special magic spell!");
    }
  },
  DWARF("Dwarf") {
    @Override
    public void specialCast() {
      System.out.println("Dwarf special spell!");
    }
  },
  HUMAN("Human") {
    @Override
    public void specialCast() {
      System.out.println("Human special spell!");
    }
  },
  HIGHELF("High Elf") {
    @Override
    public void specialCast() {
      System.out.println("Human special spell!");
    }
  },
  MOUNTAINDWARF("Mountain Dwarf") {
    @Override
    public void specialCast() {
      System.out.println("Mountain Dwarf special spell!");
    }
  },
  ORC("Orc") {
    @Override
    public void specialCast() {
      System.out.println("Orc special spell!");
    }
  };

  private final String raceType;

  RaceType(String raceType) {
    this.raceType = raceType;
  }

  public abstract void specialCast();

  @Override
  public String toString() {
    return raceType;
  }
}
