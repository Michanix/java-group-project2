package components.subscenes.ingamescenes.firstadventure;

import components.buttons.DefaultButton;
import entities.player.DiceType;
import entities.player.Player;
import javafx.scene.text.Text;
import utils.DiceAction;

// TODO: return something when player dies
// TODO: proper Text display
public class RightTurnPane extends AbstracPane {

  public RightTurnPane(Player player, String textname) {
    super(player, textname);
    DefaultButton rollTheDie = new DefaultButton("Roll the die!");
    rollTheDie.setOnMouseClicked(
        e -> {
          int result = DiceAction.roll2Dices(DiceType.D6);
          if (result < 10) {
            setCenter(
                new Text("Unfortunately you didn't see it fast enough and fell to your death."));
          } else {
            getScene().setRoot(new TrapEscapePane(player, "escapedTrap"));
          }
        });
    addToActionMenu(rollTheDie);
  }
}
