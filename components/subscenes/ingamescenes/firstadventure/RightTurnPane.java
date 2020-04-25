package components.subscenes.ingamescenes.firstadventure;

import components.actionmenu.ActionMenu;
import components.buttons.DefaultButton;
import entities.player.DiceType;
import entities.player.Player;
import javafx.scene.text.Text;
import textfiles.TextType;
import utils.DiceAction;

public class RightTurnPane extends AbstracPane {

  public RightTurnPane(Player player, String textname, TextType textType) {
    super(textname, textType);
    DefaultButton rollTheDie = new DefaultButton("Roll the die!");
    ActionMenu actionMenu = new ActionMenu();
    rollTheDie.setOnMouseClicked(
        e -> {
          int result = DiceAction.roll2Dices(DiceType.D6);
          if (result < 10) {
            setCenter(new Text("You died"));
          } else {
            getScene().setRoot(new TrapEscapePane(player, "escapedTrap", TextType.FUNCTIONAL));
          }
        });
    actionMenu.getChildren().add(rollTheDie);
    setRight(actionMenu);
  }
}
