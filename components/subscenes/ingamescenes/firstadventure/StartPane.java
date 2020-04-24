package components.subscenes.ingamescenes.firstadventure;

import components.buttons.DefaultButton;
import entities.player.Player;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import textfiles.TextType;

// TODO: more generic access to texts

public class StartPane extends AbstracPane {
  private Player player;

  public StartPane(Stage mainStage, String textname, TextType textType) {
    super(mainStage, textname, textType);
    HBox bottomMenu = new HBox();
    DefaultButton right = new DefaultButton("right");
    DefaultButton left = new DefaultButton("left");
    DefaultButton forward = new DefaultButton("forward");

    left.setOnMouseClicked(
        e -> {
          AbstracPane leftTurn = new LeftTurnPane(mainStage, "armorFound", TextType.REGULAR);
          mainStage.getScene().setRoot(leftTurn);
        });

    right.setOnMouseClicked(
        e -> {
          AbstracPane rightTurn = new RightTurnPane(mainStage, "trap", TextType.FUNCTIONAL);
          mainStage.getScene().setRoot(rightTurn);
        });

    bottomMenu.getChildren().addAll(left, forward, right);
    bottomMenu.setSpacing(10);
    setBottom(bottomMenu);
  }
}
