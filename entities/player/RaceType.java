package entities.player;

// Description of races was borrowed from https://www.lordswm.com/help.php?section=37
// and https://www.dndbeyond.com/races

public enum RaceType {
  WOODELF("Wood Elf") {
    @Override
    public void specialCast() {
      System.out.println("Elf special magic spell!");
    }

    @Override
    public String getDescription() {
      return "As a wood elf, you have keen senses and intuition,\n"
          + "and your fleet feet carry you quickly and\n"
          + "stealthily through your native forests.";
    }
  },
  HIGHELF("High Elf") {
    @Override
    public void specialCast() {
      System.out.println("Human special spell!");
    }

    @Override
    public String getDescription() {
      return "As a high elf, you have a keen mind and\n"
          + "a mastery of at least the basics of magic. ";
    }
  },
  HUMAN("Human") {
    @Override
    public void specialCast() {
      System.out.println("Human special spell!");
    }

    @Override
    public String getDescription() {
      return "While possessing rather weak magic,\n"
          + "Human race rely upon their physical strength and tactical planning.";
    }
  },
  HILLDWARF("Hill Dwarf") {
    @Override
    public void specialCast() {
      System.out.println("Dwarf special spell!");
    }

    @Override
    public String getDescription() {
      return "As a hill dwarf, you have keen senses, deep intuition,\n"
          + "and remarkable resilience.\n"
          + "The gold dwarves of Faerûn in their mighty\n"
          + "southern kingdom are hill dwarves,\n"
          + "as are the exiled Neidar and\n"
          + "the debased Klar of Krynn in the Dragonlance setting.";
    }
  },
  MOUNTAINDWARF("Mountain Dwarf") {
    @Override
    public void specialCast() {
      System.out.println("Mountain Dwarf special spell!");
    }

    @Override
    public String getDescription() {
      return "As a mountain dwarf, you’re strong and hardy,\n"
          + "accustomed to a difficult life in rugged terrain.\n"
          + "You’re probably on the tall side (for a dwarf),\n"
          + "and tend toward lighter coloration.\n "
          + "The shield dwarves of northern Faerûn,\n"
          + "as well as the ruling Hylar clan and\n"
          + "the noble Daewar clan of Dragonlance,\n"
          + "are mountain dwarves.";
    }
  },
  BARBARIAN("Barbarian") {
    @Override
    public void specialCast() {
      System.out.println("Orc special spell!");
    }

    @Override
    public String getDescription() {
      return "Barbarians kept the foundations of their culture from\n"
          + "ancient times to this day nearly unchanged.\n"
          + "Might and swiftness are the basis of their race.\n";
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
