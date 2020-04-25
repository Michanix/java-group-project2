package components.subscenes.ingamescenes.firstadventure;

import components.AdventureManager;
import components.buttons.DefaultButton;
import entities.player.ArmorType;
import entities.player.Player;
import entities.player.RaceType;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import textfiles.TextType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// TODO: more generic access to texts

public class StartPane extends AbstracPane {

  public StartPane(Player player, String textname, TextType textType) {
    super(textname, textType);
    HBox bottomMenu = new HBox();
    DefaultButton right = new DefaultButton("right");
    DefaultButton left = new DefaultButton("left");
    DefaultButton forward = new DefaultButton("forward");
    Map<String, AbstracPane> panes = new HashMap<>();
    List<AbstracPane> visited = new ArrayList<>();

    left.setOnMouseClicked(e -> {
      getScene().setRoot(new LeftTurnPane(player, "weaponFound", TextType.REGULAR));
    });
    right.setOnMouseClicked(e -> {
      getScene().setRoot(new RightTurnPane(player,"trap", TextType.FUNCTIONAL));
    });

/*
    left.setOnMouseClicked(
        e -> {
        if (leftTurn not in visited) {
          leftTurn.init
          visited.add(leftTurn)
          } else {
            "you already was there"
        });
    right.setOnMouseClicked(
        e -> {
          AbstracPane rightTurn = new RightTurnPane(mainStage, "trap", TextType.FUNCTIONAL);
          mainStage.getScene().setRoot(rightTurn);
        });


 */
    bottomMenu.getChildren().addAll(left, forward, right);
    bottomMenu.setSpacing(10);
    setBottom(bottomMenu);
  }
}
