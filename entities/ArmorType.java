package entities;

public enum ArmorType {
  HEAVYARMOR("Heavy armor"),
  LIGHTARMOR("Light armor"),
  GARMENT("Garment");

  private final String armorType;

  ArmorType(String armorType) {
    this.armorType = armorType;
  }

  @Override
  public String toString() {
    return armorType;
  }
}