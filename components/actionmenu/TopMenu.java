package components.actionmenu;

import entities.player.Player;
import javafx.scene.control.*;
import utils.WriteToFile;

public class TopMenu extends MenuBar {
  public TopMenu(Player player) {
    Menu armor      = new Menu("Armor");
    Menu weapon     = new Menu("Weapon");
    Menu abilities  = new Menu("Abilities");
    Menu health     = new Menu("Health");
    Menu experience = new Menu("Experience");
    Menu stats      = new Menu("Stats");
    Menu damage     = new Menu("Damage");
    Menu defense    = new Menu("Defense");
    Menu settings   = new Menu("Settings");

    MenuItem armorItem      = new MenuItem(player.getArmorType().toString());
    MenuItem weaponItem     = new MenuItem(player.getWeaponType().toString());
    MenuItem abilitiesItems = new MenuItem(formatAbilities(player));
    MenuItem hpItem         = new MenuItem(String.valueOf(player.getHp()));
    MenuItem expItem        = new MenuItem(String.valueOf(player.getExp()));

    // Stats
    MenuItem physDefItem  = new MenuItem(String.format("Physical: %d", player.getPhysDef()));
    MenuItem magDefItem   = new MenuItem(String.format("Magical: %d", player.getMagicDef()));
    MenuItem physDmgItem  = new MenuItem(String.format("Physical: %d", player.getPhysDmg()));
    MenuItem magDmgItem   = new MenuItem(String.format("Magical: %d", player.getMagicDmg()));

    Button saveBtn = new Button("Save");

    CustomMenuItem savePlayerItem = new CustomMenuItem();
    savePlayerItem.setContent(saveBtn);
    savePlayerItem.setOnAction(e -> {
      WriteToFile.writePlayerToFile(player);
    });


    armor.getItems().add(armorItem);
    weapon.getItems().add(weaponItem);
    abilities.getItems().add(abilitiesItems);
    health.getItems().add(hpItem);
    experience.getItems().add(expItem);
    // Stats
    defense.getItems().addAll(physDefItem, magDefItem);
    damage.getItems().addAll(physDmgItem, magDmgItem);
    stats.getItems().addAll(defense, damage);

    settings.getItems().add(savePlayerItem);

    getMenus().addAll(health, armor, weapon, stats, abilities, experience, settings);
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
