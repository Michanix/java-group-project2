package entities.player;

// Making use of Static Factory method pattern
// Will see how it plays out tho...

public class Player {
  private String       nickname;
  private int               exp; // player current experience
  private double             hp; // Health
  private boolean         state; // Dead or alive?
  private boolean   inAdventure;
  private RaceType     raceType;
  private Abilities   abilities;
  private WeaponType weaponType;
  private ArmorType   armorType;

  // Constructor for creating New Player
  private Player(String nickname, RaceType raceType, ArmorType armorType) {
             setNickname(nickname);
    this.exp          =          0;
    this.hp           =        100;
    this.state        =       true;
    this.inAdventure  =      false;
    this.raceType     =   raceType;
    this.abilities    = Abilities.initAbilities();
    this.weaponType   = WeaponType.BAREHANDS; // new Players have to start without real weapon
    this.armorType    =  armorType;
  }

  // Constructor to load existing Player from file
  private Player(
      String nickname, int exp, RaceType raceType,
      Abilities abilities, WeaponType weaponType, ArmorType armorType) {
    this.nickname    =   nickname;
    this.exp         =        exp;
    this.hp          =        100;
    this.state       =       true;
    this.inAdventure =      false;
    this.raceType    =   raceType;
    this.abilities   =  abilities;
    this.weaponType  = weaponType;
    this.armorType   =  armorType;
  }


  public static Player createNewPlayer(
      String nickname, RaceType raceType, ArmorType armorType) {
    return new Player(nickname, raceType, armorType);
  }

  public static Player loadExistingPlayer(
      String nickname, int exp, RaceType raceType,
      Abilities abilities, WeaponType weaponType, ArmorType armorType) {
    return new Player(nickname, exp, raceType, abilities, weaponType, armorType);
  }

  // Overrides
  @Override
  public String toString() {
    return "Player{"
        + "name="
        + nickname
        + ", experience="
        + exp
        + ", state="
        + state
        + ", inAdventure="
        + inAdventure
        + ", raceType="
        + raceType
        + ", "
        + abilities
        + ", weaponType="
        + weaponType
        + ", armorType="
        + armorType
        + '}';
  }
  // Getters and setters
  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    if(nickname.isBlank() | nickname.length() > 12) {
      throw new IllegalArgumentException("Nickname can be empty or longer than 12 characters");
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