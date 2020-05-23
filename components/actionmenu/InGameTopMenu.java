package components.actionmenu;

import components.modals.SaveModel;
import entities.player.Abilities;
import entities.player.Player;
import entities.player.PlayerStats;
import javafx.scene.control.CustomMenuItem;
import javafx.scene.control.Menu;
import utils.WriteToFile;

/*
Menu that is seen on top while already in game(adventure).
 */

public class InGameTopMenu extends AbstractTopMenu {
  public InGameTopMenu(Player player) {
    PlayerStats playerStats   = player.getStats();
    Abilities playerAbilities = player.getAbilities();
    String physDef  = formatStat("Physical", playerStats.getPhysDef());
    String magDef   = formatStat("Magical", playerStats.getMagicDef());
    String physDmg  = formatStat("Physical", playerStats.getPhysDmg());
    String magDmg   = formatStat("Magical", playerStats.getMagicDmg());

    Menu armor      = createMenuWithItems("Armor", player.getArmorType().toString());
    Menu weapon     = createMenuWithItems("Weapon", player.getWeaponType().toString());
    Menu abilities  = createMenuWithItems("Abilities", formatAbilities(playerAbilities));
    Menu health     = createMenuWithItems("Health", String.valueOf(player.getHp()));
    Menu experience = createMenuWithItems("Experience", String.valueOf(player.getExp()));
    // Nested menus
    Menu damage     = createMenuWithItems("Damage", physDmg, magDmg);
    Menu defense    = createMenuWithItems("Defense", physDef, magDef);
    Menu stats      = new Menu("Stats");

    CustomMenuItem savePlayerItem = createCustomMenuBtn("Save");

    // Controllers for buttons
    savePlayerItem.setOnAction(
        e -> {
          WriteToFile.writePlayerToFile(player);
          SaveModel saved = new SaveModel();
          saved.showAndWait();
        });

    stats.getItems().addAll(defense, damage);     // Nested menu

    addToSettings(savePlayerItem);
    addMenus(health, armor, weapon, stats, abilities, experience);
  }

  /*
  Function to format physical and magical parameters of a Player
  to a suitable String format
   */
  private String formatStat(String text, int stat) {
    return String.format("%s: %d", text, stat);
  }

  private String formatAbilities(Abilities abilities) {
    return String.format(
        "wisdom: %s\n"
            + "strength: %s\n"
            + "charisma: %s\n"
            + "dexterity: %s\n"
            + "constitution: %s\n"
            + "intelligence: %s",
        abilities.getWisdom(),
        abilities.getStrength(),
        abilities.getCharisma(),
        abilities.getDexterity(),
        abilities.getConstitution(),
        abilities.getIntelligence());
  }
}
