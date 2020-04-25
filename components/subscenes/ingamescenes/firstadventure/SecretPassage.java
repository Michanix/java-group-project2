package components.subscenes.ingamescenes.firstadventure;

import components.actionmenu.ActionMenu;
import components.buttons.DefaultButton;
import entities.player.ArmorType;
import entities.player.Player;
import javafx.scene.text.Text;
import textfiles.TextType;
import utils.GetRandomType;

public class SecretPassage extends AbstracPane {

  public SecretPassage(Player player, String textname, TextType textType) {
    super(textname, textType);
    ArmorType rndArmor = GetRandomType.randomEnum(ArmorType.class);
    ActionMenu actionMenu = new ActionMenu();
    setRight(new Text(String.format("You got %s", rndArmor.toString())));
    player.setArmorType(rndArmor);
    DefaultButton backButton = new DefaultButton("Back");
    backButton.setOnMouseClicked(
        e -> {
          getScene().setRoot(new StartPane(player, "begining", TextType.FUNCTIONAL));
        });
    actionMenu.getChildren().add(backButton);
    setRight(actionMenu);
  }
}
