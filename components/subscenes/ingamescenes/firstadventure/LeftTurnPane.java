package components.subscenes.ingamescenes.firstadventure;

import components.buttons.GoBackButton;
import entities.player.Player;
import entities.player.WeaponType;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import utils.GetRandomType;

// TODO: proper Text display
// TODO: if nothing new found, tell about it, lol
public class LeftTurnPane extends AbstracPane {

  public LeftTurnPane(Player player, String textname) {
    super(player, textname);
    WeaponType rndWeapon = GetRandomType.randomEnum(WeaponType.class);
    Text weapon =
        new Text(
            String.format(
                "You now have %s. \n"
                    + "Your physical damage increased by %d. \n"
                    + "Your magical damage increased by %d",
                rndWeapon.toString(), rndWeapon.getPhysDmg(), rndWeapon.getMagicDmg()));
    weapon.setFont(new Font(20));
    weapon.setFill(Color.CADETBLUE);
    player.setWeaponType(rndWeapon);
    GoBackButton backButton = new GoBackButton();

    backButton.setOnMouseClicked(
        e -> {
          getScene().setRoot(new StartPane(player, "begining"));
        });
    addToActionMenu(backButton);
    addToBottomMenu(weapon);
  }
}
