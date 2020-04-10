package entities;

import java.util.Arrays;

public class Abilities {
  private int       wisdom;
  private int     strength;
  private int     charisma;
  private int    dexterity;
  private int constitution;
  private int intelligence;

  public Abilities() {
    this.wisdom       = generateRndAbilityVal();
    this.strength     = generateRndAbilityVal();
    this.charisma     = generateRndAbilityVal();
    this.dexterity    = generateRndAbilityVal();
    this.constitution = generateRndAbilityVal();
    this.intelligence = generateRndAbilityVal();
  }

  public Abilities(
          int wisdom, int strength, int charisma,
          int dexterity, int constitution, int intelligence) {
    this.wisdom       =       wisdom;
    this.strength     =     strength;
    this.charisma     =     charisma;
    this.dexterity    =    dexterity;
    this.constitution = constitution;
    this.intelligence = intelligence;
  }

  // "Roll four 6-sided dice and record the total of the highest three dice"
  private int generateRndAbilityVal() {
    int d20 = 20;
    int[] values = new int[4];
    for (int i = 0; i < 4; i++) {
      int x = (int) (Math.random() * d20 + 1);
      values[i] = x;
    }
    Arrays.sort(values);
    return values[1] + values[2] + values[3];
  }

  // Overrides
  @Override
  public String toString() {
    return "wisdom="
        + wisdom
        + ", strength="
        + strength
        + ", charisma="
        + charisma
        + ", dexterity="
        + dexterity
        + ", constitution="
        + constitution
        + ", intelligence="
        + intelligence;
  }

  // gets and sets
  public int getStrength() {
    return strength;
  }

  public void setStrength(int strength) {
    this.strength = strength;
  }

  public int getDexterity() {
    return dexterity;
  }

  public void setDexterity(int dexterity) {
    this.dexterity = dexterity;
  }

  public int getConstitution() {
    return constitution;
  }

  public void setConstitution(int constitution) {
    this.constitution = constitution;
  }

  public int getIntelligence() {
    return intelligence;
  }

  public void setIntelligence(int intelligence) {
    this.intelligence = intelligence;
  }

  public int getWisdom() {
    return wisdom;
  }

  public void setWisdom(int wisdom) {
    this.wisdom = wisdom;
  }

  public int getCharisma() {
    return charisma;
  }

  public void setCharisma(int charisma) {
    this.charisma = charisma;
  }
}