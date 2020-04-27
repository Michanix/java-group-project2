package entities.player;

public enum ArmorType {
  HEAVYARMOR("Heavy armor", 75, 30) {
    @Override
    public String getDescription() {
      return "Heavy armor is good at protecting against\n"
          + "Physical attacks due to its high Physical\n"
          + "defensive power, but makes you more vulnerable\n"
          + "to magical attacks.";
    }
  },
  LIGHTARMOR("Light armor", 50, 50) {
    @Override
    public String getDescription() {
      return "Light armor has a well balanced Physical\n"
          + "and Magical defensive power.\n"
          + "It makes a good choice when you can't\n"
          + "decide between Heavy Armor and Robe.";
    }
  },
  ROBE("Robe", 35, 70) {
    @Override
    public String getDescription() {
      return "Robes have a high magical defensive power,\n"
          + "reducing damage from enemies magical attacks,\n"
          + "but makes you more vulnerable to Physical attacks.";
    }
  };

  private final String armorType;
  private final int      physDef;
  private final int       magDef;

  ArmorType(String armorType, int physDef, int magDef) {
    this.armorType = armorType;
    this.physDef   =   physDef;
    this.magDef    =    magDef;
  }

  public abstract String getDescription();

  public int getPhysDef() {
    return physDef;
  }

  public int getMagDef() {
    return magDef;
  }

  @Override
  public String toString() {
    return armorType;
  }
}
