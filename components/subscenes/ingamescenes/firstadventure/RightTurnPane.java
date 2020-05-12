package components.subscenes.ingamescenes.firstadventure;

import components.buttons.DefaultButton;
import entities.player.DiceType;
import entities.player.Player;
import javafx.scene.text.Text;
import utils.DiceAction;

public class RightTurnPane extends AbstracPane {

  public RightTurnPane(Player player, String textname) {
    super(player, textname);
    DefaultButton rollTheDie = new DefaultButton("Roll the die!");
    rollTheDie.setOnMouseClicked(
        e -> {
          int result = DiceAction.roll2Dices(DiceType.D6);
          if (result < 10) {
              getScene().setRoot(new EndPane(player, "playerDied"));
          } else {
            getScene().setRoot(new TrapEscapePane(player, "escapedTrap"));
          }
        });
    addToActionMenu(rollTheDie);
  }
}
