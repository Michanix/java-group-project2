package components.actionmenu;

import components.StartGameManager;
import entities.player.Player;
import javafx.scene.control.*;
import javafx.stage.Stage;
import utils.WriteToFile;

public class TopMenu extends MenuBar {
  public TopMenu(Player player) {
    String physDef = formatStat("Physical", player.getPhysDef());
    String magDef  = formatStat("Magical", player.getMagicDef());
    String physDmg = formatStat("Physical", player.getPhysDmg());
    String magDmg  = formatStat("Magical", player.getMagicDmg());

    Menu armor      = createMenuWithItems("Armor", player.getArmorType().toString());
    Menu weapon     = createMenuWithItems("Weapon", player.getWeaponType().toString());
    Menu abilities  = createMenuWithItems("Abilities", formatAbilities(player));
    Menu health     = createMenuWithItems("Helath", String.valueOf(player.getHp()));
    Menu experience = createMenuWithItems("Experience", String.valueOf(player.getExp()));
    Menu damage     = createMenuWithItems("Damage", physDmg, magDmg);
    Menu defense    = createMenuWithItems("Defense", physDef, magDef);
    Menu stats      = new Menu("Stats");
    Menu settings   = new Menu("Settings");

    CustomMenuItem savePlayerItem = createCustomMenuBtn("Save");
    CustomMenuItem backToMenuItem = createCustomMenuBtn("Main menu");

    // Controllers for buttons
    savePlayerItem.setOnAction(e -> {
      WriteToFile.writePlayerToFile(player);
    });

    backToMenuItem.setOnAction(e -> {
      StartGameManager mainMenu = new StartGameManager();
      mainMenu.startGameMan((Stage)this.getScene().getWindow());
    });

    stats.getItems().addAll(defense, damage);
    settings.getItems().addAll(savePlayerItem, backToMenuItem);
    getMenus().addAll(health, armor, weapon, stats, abilities, experience, settings);
  }

  private CustomMenuItem createCustomMenuBtn(String text) {
    Button btn = new Button(text);
    btn.setStyle("-fx-background-color: transparent;");
    return new CustomMenuItem(btn);
  }

  /*
  Helper function to reduce repetitive code.
  Helps create Menu and Items inside of it in range from 1 to many.
   */
  private Menu createMenuWithItems(String menuName, String...menuItemText) {
    Menu menu = new Menu(menuName);
    for(String txt: menuItemText) {
        menu.getItems().add(new MenuItem(txt));
    }
    return menu;
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
