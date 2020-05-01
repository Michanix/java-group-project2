package components.subscenes.ingamescenes.firstadventure;

import components.buttons.GoBackButton;
import entities.player.ArmorType;
import entities.player.Player;
import javafx.scene.text.Text;
import utils.GetRandomType;

// TODO: if player finds nothing new, do something

public class SecretPassage extends AbstracPane {

  public SecretPassage(Player player, String textname) {
    super(player, textname);
    ArmorType rndArmor = GetRandomType.randomEnum(ArmorType.class);
    setBottom(new Text(String.format("You got %s", rndArmor.toString())));
    player.setArmorType(rndArmor);
    GoBackButton backButton = new GoBackButton();

    backButton.setOnMouseClicked(
        e -> {
          getScene().setRoot(new StartPane(player, "begining"));
        });
    addToActionMenu(backButton);
  }
}
