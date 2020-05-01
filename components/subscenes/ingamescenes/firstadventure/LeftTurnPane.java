package components.subscenes.ingamescenes.firstadventure;

import components.buttons.GoBackButton;
import entities.player.Player;
import entities.player.WeaponType;
import javafx.scene.text.Text;
import utils.GetRandomType;

// TODO: proper Text display
// TODO: if nothing new found, tell about it, lol
public class LeftTurnPane extends AbstracPane {

  public LeftTurnPane(Player player, String textname) {
    super(player, textname);
    WeaponType rndWeapon = GetRandomType.randomEnum(WeaponType.class);
    setBottom(new Text(String.format("You got %s", rndWeapon.getWeapon())));
    player.setWeaponType(rndWeapon);
    GoBackButton backButton = new GoBackButton();

    backButton.setOnMouseClicked(
        e -> {
          getScene().setRoot(new StartPane(player, "begining"));
        });
    addToActionMenu(backButton);
  }
}
