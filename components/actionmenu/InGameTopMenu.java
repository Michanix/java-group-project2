package components.actionmenu;

import components.modals.SaveModel;
import entities.player.Player;
import javafx.scene.control.CustomMenuItem;
import javafx.scene.control.Menu;
import utils.WriteToFile;

public class InGameTopMenu extends AbstractTopMenu {
  public InGameTopMenu(Player player) {
    String physDef  = formatStat("Physical", player.getPhysDef());
    String magDef   = formatStat("Magical", player.getMagicDef());
    String physDmg  = formatStat("Physical", player.getPhysDmg());
    String magDmg   = formatStat("Magical", player.getMagicDmg());

    Menu armor      = createMenuWithItems("Armor", player.getArmorType().toString());
    Menu weapon     = createMenuWithItems("Weapon", player.getWeaponType().toString());
    Menu abilities  = createMenuWithItems("Abilities", formatAbilities(player));
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
