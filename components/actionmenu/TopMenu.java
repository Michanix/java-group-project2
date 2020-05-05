package components.actionmenu;

import entities.player.Player;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

public class TopMenu extends MenuBar {
  public TopMenu(Player player) {
    Menu armor = new Menu("Armor");
    Menu weapon = new Menu("Weapon");
    Menu abilities = new Menu("Abilities");
    Menu health = new Menu("Health");
    Menu experience = new Menu("Experience");
    Menu damage = new Menu("Damage");
    Menu defense = new Menu("Defense");

    MenuItem armorItem = new MenuItem(player.getArmorType().toString());
    MenuItem weaponItem = new MenuItem(player.getWeaponType().toString());
    MenuItem abilitiesItems = new MenuItem(formatAbilities(player));
    MenuItem hpItem = new MenuItem(String.valueOf(player.getHp()));
    MenuItem expItem = new MenuItem(String.valueOf(player.getExp()));
    MenuItem physDefItem = new MenuItem(String.format("Physical defense: %d",player.getPhysDef()));
    MenuItem magDefItem = new MenuItem(String.format("Magical defense: %d",player.getMagicDef()));
    MenuItem dmgItem = new MenuItem(
            "Damage calculated based\n" +
            " on D6 and D8 dices.");

    armor.getItems().add(armorItem);
    weapon.getItems().add(weaponItem);
    abilities.getItems().add(abilitiesItems);
    health.getItems().add(hpItem);
    experience.getItems().add(expItem);
    defense.getItems().addAll(physDefItem, magDefItem);
    damage.getItems().add(dmgItem);

    getMenus().addAll(health, armor, weapon, defense, damage, abilities, experience);
  }

  private String formatAbilities(Player player) {
    String s =
        String.format(
            "wisdom: %s\n"
                + "strength: %s\n"
                + "charisma: %s\n"
                + "dexterity: %s\n"
                + "constitution: %s\n"
                + "intelligence: %s",
            player.getAbilities().getWisdom(),
            player.getAbilities().getStrength(),
            player.getAbilities().getCharisma(),
            player.getAbilities().getDexterity(),
            player.getAbilities().getConstitution(),
            player.getAbilities().getIntelligence());

    return s;
  }
}
