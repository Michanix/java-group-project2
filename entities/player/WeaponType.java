package entities.player;

public enum WeaponType {
  BAREHANDS("Bare hands", 1, 1),
  SWORD("Sword", 30, 10),
  AXE("Axe", 45, 1),
  BOW("Bow", 30, 30),
  WIZARDSTAFF("Wizard staff", 15, 45);

  private final String  weapon;
  private final int    physDmg;
  private final int   magicDmg;

  WeaponType(String weapon, int physDmg, int magicDmg) {
    this.weapon   =   weapon;
    this.physDmg  =  physDmg;
    this.magicDmg = magicDmg;
  }

  public String getWeapon() {
    return weapon;
  }

  public int getPhysDmg() {
    return physDmg;
  }

  public int getMagicDmg() {
    return magicDmg;
  }

  @Override
  public String toString() {
    return weapon;
  }
}