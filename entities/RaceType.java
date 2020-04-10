package entities;

public enum RaceType {
  ELF("Elf"),
  DWARF("Dwarf"),
  HUMAN("Human"),
  HIGHELF("High Elf"),
  MOUNTAINDWARF("Mountain Dwarf"),
  ORC("Orc");

  private final String raceType;

  RaceType(String raceType) {
    this.raceType = raceType;
  }

  @Override
  public String toString() {
    return raceType;
  }
}