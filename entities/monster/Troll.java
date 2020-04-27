package entities.monster;

public class Troll extends Monster {

  public Troll(
          int hp, int phyDef,
          int magDef, int expPer) {
    super(hp, phyDef, magDef, expPer);
  }

  @Override
  public void specialAttack() { System.out.println("Troll special attack!");}

  @Override
  public String toString() {
    return super.toString();
  }
}
