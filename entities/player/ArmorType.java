package entities.player;

public enum ArmorType {
  HEAVYARMOR("Heavy armor") {
    @Override
    public String getDescription() {
      return null;
    }
  },
  LIGHTARMOR("Light armor") {
    @Override
    public String getDescription() {
      return null;
    }
  },
  GARMENT("Garment") {
    @Override
    public String getDescription() {
      return null;
    }
  };

  private final String armorType;

  ArmorType(String armorType) {
    this.armorType = armorType;
  }
  public abstract String getDescription();
  @Override
  public String toString() {
    return armorType;
  }
}