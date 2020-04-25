package components.subscenes.ingamescenes.firstadventure;

import components.buttons.DefaultButton;
import entities.player.ArmorType;
import entities.player.Player;
import javafx.scene.text.Text;
import utils.GetRandomType;

public class SecretPassage extends AbstracPane {

  public SecretPassage(Player player, String textname) {
    super(player, textname);
    ArmorType rndArmor = GetRandomType.randomEnum(ArmorType.class);
    setRight(new Text(String.format("You got %s", rndArmor.toString())));
    player.setArmorType(rndArmor);
    DefaultButton backButton = new DefaultButton("Back");
    backButton.setOnMouseClicked(
        e -> {
          getScene().setRoot(new StartPane(player, "begining"));
        });
    addToActionMenu(backButton);
  }
}
