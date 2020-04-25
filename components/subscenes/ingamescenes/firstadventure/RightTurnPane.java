package components.subscenes.ingamescenes.firstadventure;

import components.buttons.DefaultButton;
import entities.player.DiceType;
import entities.player.Player;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import textfiles.TextType;
import utils.DiceAction;

public class RightTurnPane extends AbstracPane {

  public RightTurnPane(Player player, String textname, TextType textType) {
    super(textname, textType);
    DefaultButton rollTheDie = new DefaultButton("Roll the die!");
    Label actionsL = new Label("Actions");
    VBox actionMenu = new VBox(10);
    rollTheDie.setOnMouseClicked(
        e -> {
          int result = DiceAction.roll2Dices(DiceType.D6);
          if (result < 10) {
            setCenter(new Text("You died"));
          } else {
            getScene().setRoot(new TrapEscapePane(player, "escapedTrap", TextType.FUNCTIONAL));
          }
        });
    actionMenu.getChildren().addAll(actionsL, rollTheDie);
    setRight(actionMenu);
  }
}
