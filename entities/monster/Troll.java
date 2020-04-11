package entities.monster;

public class Troll extends Monster {

  public Troll(
          int hp, double phyDmg, double magDmg,
          double phyDef, double magDef, int expPer) {
    super(hp, phyDmg, magDmg, phyDef, magDef, expPer);
  }

  @Override
  public void attack() { System.out.println("Troll attacks!");}

  @Override
  public void specialAttack() { System.out.println("Troll special attack!");}

  @Override
  public String toString() {
    return super.toString();
  }
}
