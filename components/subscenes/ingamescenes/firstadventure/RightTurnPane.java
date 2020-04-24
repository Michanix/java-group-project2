package components.subscenes.ingamescenes.firstadventure;

import components.buttons.DefaultButton;
import entities.player.DiceType;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import textfiles.TextType;
import utils.DiceAction;

public class RightTurnPane extends AbstracPane {

  public RightTurnPane(Stage mainStage, String textname, TextType textType) {
    super(mainStage, textname, textType);
    DefaultButton rollTheDie = new DefaultButton("Roll the die!");
    Label actionsL = new Label("Actions");
    VBox actionMenu = new VBox(10);
    rollTheDie.setOnMouseClicked(
        e -> {
          int result = DiceAction.roll2Dices(DiceType.D6);
          if (result < 10) {
            setCenter(new Text("You died"));
          } else {
            setCenter(new Text("next scene"));
          }
        });
    actionMenu.getChildren().addAll(actionsL, rollTheDie);
    setRight(actionMenu);
  }
}
