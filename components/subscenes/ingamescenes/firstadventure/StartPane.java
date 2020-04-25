package components.subscenes.ingamescenes.firstadventure;

import components.actionmenu.ActionMenu;
import components.buttons.DefaultButton;
import entities.player.Player;
import textfiles.TextType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// TODO: more generic access to texts

public class StartPane extends AbstracPane {

  public StartPane(Player player, String textname, TextType textType) {
    super(textname, textType);
    ActionMenu actionMenu = new ActionMenu();
    DefaultButton right = new DefaultButton("right");
    DefaultButton left = new DefaultButton("left");
    DefaultButton forward = new DefaultButton("forward");
    Map<String, AbstracPane> panes = new HashMap<>();
    List<AbstracPane> visited = new ArrayList<>();

    left.setOnMouseClicked(
        e -> {
          getScene().setRoot(new LeftTurnPane(player, "weaponFound", TextType.REGULAR));
        });
    right.setOnMouseClicked(
        e -> {
          getScene().setRoot(new RightTurnPane(player, "trap", TextType.FUNCTIONAL));
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
    actionMenu.getChildren().addAll(left, forward, right);
    setRight(actionMenu);
  }
}
