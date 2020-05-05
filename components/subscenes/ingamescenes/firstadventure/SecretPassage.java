package components.subscenes.ingamescenes.firstadventure;

import components.buttons.GoBackButton;
import entities.player.ArmorType;
import entities.player.Player;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import utils.GetRandomType;

// TODO: if player finds nothing new, do something

public class SecretPassage extends AbstracPane {

  public SecretPassage(Player player, String textname) {
    super(player, textname);
    ArmorType rndArmor = GetRandomType.randomEnum(ArmorType.class);
    player.setArmorType(rndArmor);
    GoBackButton backButton = new GoBackButton();
    Text armor =
        new Text(
            String.format(
                "You now have %s. \n"
                    + "Your physical defense increased by %d. \n"
                    + "Your magical defense increased by %d",
                rndArmor.toString(), rndArmor.getPhysDef(), rndArmor.getMagDef()));
    armor.setFont(new Font(20));
    armor.setFill(Color.CADETBLUE);

    backButton.setOnMouseClicked(
        e -> {
          getScene().setRoot(new StartPane(player, "begining"));
        });
    addToActionMenu(backButton);
    addToBottomMenu(armor);
  }
}
