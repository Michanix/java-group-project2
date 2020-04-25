package components.subscenes.ingamescenes.firstadventure;

import components.buttons.DefaultButton;
import entities.player.Player;
import entities.player.WeaponType;
import javafx.scene.text.Text;
import textfiles.TextType;
import utils.GetRandomType;

public class LeftTurnPane extends AbstracPane {

  public LeftTurnPane(Player player, String textname, TextType textType) {
    super(textname, textType);
    WeaponType rndWeapon = GetRandomType.randomEnum(WeaponType.class);
    setRight(new Text(String.format("You got %s", rndWeapon.toString())));
    player.setWeaponType(rndWeapon);
    DefaultButton backButton = new DefaultButton("Back");
    backButton.setOnMouseClicked(
        e -> {
          getScene().setRoot(new StartPane(player, "begining", TextType.FUNCTIONAL));
        });
    setLeft(backButton);
  }
}
