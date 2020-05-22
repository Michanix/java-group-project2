package entities.player;

// Making use of Static Factory method pattern
// Will see how it plays out tho...

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import utils.DiceAction;

import java.util.Objects;
import java.util.UUID;

public class Player {
  private UUID id = UUID.randomUUID();
  private String       nickname;
  private int               exp; // player current experience
  private final IntegerProperty    hp = new SimpleIntegerProperty(100); // Health points
  private final IntegerProperty    mp = new SimpleIntegerProperty(100); // Mana points
  private RaceType     raceType;
  private Abilities   abilities;
  private WeaponType weaponType;
  private ArmorType   armorType;
  // Physical and magical offensive and defensive stats
  private final PlayerStats     stats;

  // Constructor for creating New Player
  private Player(
          String nickname, RaceType raceType, ArmorType armorType) {
             setNickname(nickname);
    this.exp          =          0;
             setRaceType(raceType);
    this.abilities    = Abilities.initAbilities();
    // new Players have to start without real weapon
    this.weaponType   = WeaponType.BAREHANDS;
           setArmorType(armorType);
    this.stats = new PlayerStats(weaponType, armorType);
  }

  // Constructor to load existing Player from file
  private Player(
      UUID id, String nickname, int exp, RaceType raceType,
      Abilities abilities, WeaponType weaponType, ArmorType armorType) {
    this.id          =         id;
    this.nickname    =   nickname;
    this.exp         =        exp;
    this.raceType    =   raceType;
    this.abilities   =  abilities;
    this.weaponType  = weaponType;
    this.armorType   =  armorType;
    this.stats       = new PlayerStats(weaponType, armorType);
  }

  public static Player createNewPlayer(
      String nickname, RaceType raceType, ArmorType armorType) {
    return new Player(nickname, raceType, armorType);
  }

  public static Player loadExistingPlayer(
      UUID id, String nickname, int exp, RaceType raceType,
      Abilities abilities, WeaponType weaponType, ArmorType armorType) {
    return new Player(id, nickname, exp, raceType, abilities, weaponType, armorType);
  }

  // attack methods
  // Damage from basic attacks calculated as outcome from
  // rolling D6 two times plus the type of Weapon the player has.
  // Refer to DiceAction class for more information
  public int basicPhysAttack() {
    int extraDmg = getWeaponType().getPhysDmg();
    int playerDmg = DiceAction.roll2Dices(DiceType.D6);
    return playerDmg + extraDmg;
  }

  // Same as previous method, but the damage from magic attacks is higher
  // because...uhm...well...you know...magic and stuff
  public int basicMagAttack() {
    int extraDmg = getWeaponType().getMagicDmg();
    int playerDmg = DiceAction.roll2Dices(DiceType.D8);
    return playerDmg + extraDmg;
  }

  public boolean isDead() {
    return getHp() < 0;
  }

  // Overrides
  @Override
  public String toString() {
    String s = String.format("Player{" +
                    "uuid='%s', " +
                    "name='%s', " +
                    "experience='%d', " +
                    "raceType='%s', " +
                    "%s, " +
                    "weaponType='%s', " +
                    "armorType='%s'" +
                    "}",
                    id,
                    nickname,
                    exp,
                    raceType,
                    abilities,
                    weaponType,
                    armorType);
    return s;
  }

  // Getters and setters
  public UUID getId() {
    return id;
  }

  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    if(nickname.isBlank()) {
      throw new IllegalArgumentException("Nickname cannot be empty.");
    } else if (nickname.length() < 3 | nickname.length() > 12) {
      throw new IllegalArgumentException("Nickname length should be from 3 to 12 characters.");
    } else {
      this.nickname = nickname;
    }
  }

  public int getExp() {
    return exp;
  }

  public void setExp(int exp) {
    this.exp = exp;
  }

  public int getHp() {
    return hp.get();
  }

  public IntegerProperty hpProperty() {
    return hp;
  }

  public void reduceHP(int dmg) {
    hp.set(getHp() - dmg);
  }

  public int getMp() {
    return mp.get();
  }

  public IntegerProperty mpProperty() {
    return mp;
  }

  public void reduceMP(int mp) {
    this.mp.set(getMp() - mp);
  }

  public RaceType getRaceType() {
    return raceType;
  }

  public void setRaceType(RaceType raceType) {
    this.raceType = Objects.requireNonNull(raceType, "RaceType cannot be null.");
  }

  public Abilities getAbilities() {
    return abilities;
  }

  public void setAbilities(Abilities abilities) {
    this.abilities = abilities;
  }

  public WeaponType getWeaponType() {
    return weaponType;
  }

  public void setWeaponType(WeaponType weaponType) {
    this.weaponType = weaponType;
  }

  public ArmorType getArmorType() {
    return armorType;
  }

  public void setArmorType(ArmorType armorType) {
    this.armorType = Objects.requireNonNull(armorType, "ArmorType cannot be null.");
  }

  public PlayerStats getStats() {
    return stats;
  }
}