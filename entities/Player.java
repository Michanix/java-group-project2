package entities;

// Making use of Static Factory method pattern
// Will see how it plays out tho...

public class Player {
  private String       nickname;
  private int               exp; // player current experience
  private boolean         state; // Dead or alive?
  private boolean   inAdventure;
  private RaceType     raceType;
  private Abilities   abilities;
  private WeaponType weaponType;
  private ArmorType   armorType;

  // Constructor for creating New Player
  private Player(String nickname, RaceType raceType, WeaponType weaponType, ArmorType armorType) {
    this.nickname     =        nickname;
    this.exp          =               0;
    this.state        =            true;
    this.inAdventure  =           false;
    this.raceType     =        raceType;
    this.abilities    = new Abilities();
    this.weaponType   =      weaponType;
    this.armorType    =       armorType;
  }

  // Constructor to load existing Player from file
  private Player(
      String nickname, int exp, RaceType raceType,
      Abilities abilities, WeaponType weaponType, ArmorType armorType) {
    this.nickname    =   nickname;
    this.exp         =        exp;
    this.state       =       true;
    this.inAdventure =      false;
    this.raceType    =   raceType;
    this.abilities   =  abilities;
    this.weaponType  = weaponType;
    this.armorType   =  armorType;
  }


  public static Player createNewPlayer(
      String nickname, int exp, RaceType raceType,
      WeaponType weaponType, ArmorType armorType) {
    return new Player(nickname, raceType, weaponType, armorType);
  }

  public static Player loadExistingPlayer(
      String nickname, int exp, RaceType raceType,
      Abilities abilities, WeaponType weaponType, ArmorType armorType) {
    return new Player(nickname, exp, raceType, abilities, weaponType, armorType);
  }

  // Overrides
  @Override
  public String toString() {
    return "Summoner{"
        + "name='"
        + nickname
        + '\''
        + ", experience="
        + exp
        + ", state="
        + state
        + ", onTheRoad="
        + inAdventure
        + ", race="
        + raceType
        + ", abilities="
        + abilities
        + ", weapon="
        + weaponType
        + ", armor="
        + armorType
        + '}';
  }
  // Getters and setters
  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  public int getExp() {
    return exp;
  }

  public void setExp(int exp) {
    this.exp = exp;
  }

  public boolean isState() {
    return state;
  }

  public void setState(boolean state) {
    this.state = state;
  }

  public boolean isInAdventure() {
    return inAdventure;
  }

  public void setInAdventure(boolean inAdventure) {
    this.inAdventure = inAdventure;
  }

  public RaceType getRaceType() {
    return raceType;
  }

  public void setRaceType(RaceType raceType) {
    this.raceType = raceType;
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
    this.armorType = armorType;
  }
}
