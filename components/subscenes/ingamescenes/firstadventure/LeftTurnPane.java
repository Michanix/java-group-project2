package components.subscenes.ingamescenes.firstadventure;

import components.buttons.DefaultButton;
import entities.player.Player;
import entities.player.WeaponType;
import javafx.scene.text.Text;
import utils.GetRandomType;

// TODO: proper Text display

public class LeftTurnPane extends AbstracPane {

  public LeftTurnPane(Player player, String textname) {
    super(player, textname);
    WeaponType rndWeapon = GetRandomType.randomEnum(WeaponType.class);
    setBottom(new Text(String.format("You got %s", rndWeapon.toString())));
    player.setWeaponType(rndWeapon);
    DefaultButton backButton = new DefaultButton("Back");
    backButton.setOnMouseClicked(
        e -> {
          getScene().setRoot(new StartPane(player, "begining"));
        });
    addToActionMenu(backButton);
  }
}
