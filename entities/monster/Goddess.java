package entities.monster;

public class Goddess extends Monster {

  public Goddess(
          int hp, int phyDef,
          int magDef, int expPer) {
    super(hp, phyDef, magDef, expPer);
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
