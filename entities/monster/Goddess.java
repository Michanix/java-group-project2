package entities.monster;

public class Goddess extends Monster {

  public Goddess(
          int hp, double phyDmg, double magDmg,
          double phyDef, double magDef, int expPer) {
    super(hp, phyDmg, magDmg, phyDef, magDef, expPer);
  }

  @Override
  public void attack() {
    System.out.println("Goddess basic attack");
  }

  @Override
  public void specialAttack() {
    System.out.println("Goddess special attack");
  }

  @Override
  public String toString() {
    return super.toString();
  }
}
