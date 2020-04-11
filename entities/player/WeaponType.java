package entities.player;

public enum WeaponType {
  BAREHANDS("Bare hands"),
  Sword("Sword"),
  AXE("Axe"),
  BOW("Bow"),
  WIZARDSTAFF("Wizard staff");

  private final String weapon;

  WeaponType(String weapon) {
    this.weapon = weapon;
  }

  @Override
  public String toString() {
    return weapon;
  }
}