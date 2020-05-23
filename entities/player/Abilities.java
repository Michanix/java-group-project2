package entities.player;

import java.util.Arrays;

/*
Class to separate hero abilities.
For new players generates random value for each ability with generateRndAbilityVal() function.
 */

public class Abilities {
  private int       wisdom;
  private int     strength;
  private int     charisma;
  private int    dexterity;
  private int constitution;
  private int intelligence;

  private Abilities() {
    this.wisdom       = generateRndAbilityVal();
    this.strength     = generateRndAbilityVal();
    this.charisma     = generateRndAbilityVal();
    this.dexterity    = generateRndAbilityVal();
    this.constitution = generateRndAbilityVal();
    this.intelligence = generateRndAbilityVal();
  }

  private Abilities(
          int wisdom, int strength, int charisma,
          int dexterity, int constitution, int intelligence) {
    this.wisdom       =       wisdom;
    this.strength     =     strength;
    this.charisma     =     charisma;
    this.dexterity    =    dexterity;
    this.constitution = constitution;
    this.intelligence = intelligence;
  }

  // Static methods for constructors
  public static Abilities initAbilities() {
    return new Abilities();
  }

  public static Abilities loadExisting(
          int wisdom, int strength, int charisma,
          int dexterity, int constitution, int intelligence) {
    return new Abilities(wisdom, strength, charisma,
            dexterity, constitution, intelligence);
  }

  // "Roll four 6-sided dice and record the total of the highest three dice"
  private int generateRndAbilityVal() {
    int d6 = DiceType.D6.getSides();
    int[] values = new int[4];
    for (int i = 0; i < 4; i++) {
      values[i] = (int) (Math.random() * d6 + 1);
    }
    Arrays.sort(values);
    return values[1] + values[2] + values[3];
  }

  // Overrides
  @Override
  public String toString() {
    return String.format(
            "wisdom='%d', " +
            "strength='%d', " +
            "charisma='%d', " +
            "dexterity='%d', " +
            "constitution='%d', " +
            "intelligence='%d'",
            wisdom,
            strength,
            charisma,
            dexterity,
            constitution,
            intelligence);
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