package components.subscenes.ingamescenes.firstadventure;

import components.actionmenu.ActionMenu;
import components.buttons.DefaultButton;
import entities.player.Player;
import javafx.scene.control.Button;

// TODO: more generic access to texts

public class StartPane extends AbstracPane {

  public StartPane(Player player, String textname) {
    super(player, textname);
    ActionMenu actionMenu = new ActionMenu();
    DefaultButton rightBtn = new DefaultButton("right");
    DefaultButton leftBtn = new DefaultButton("left");
    DefaultButton forwardBtn = new DefaultButton("forward");

    leftBtn.setOnMouseClicked(
        e -> {
          getScene().setRoot(new LeftTurnPane(player, "weaponFound"));
        });
    rightBtn.setOnMouseClicked(
        e -> {
          getScene().setRoot(new RightTurnPane(player, "trap"));
        });
    forwardBtn.setOnMouseClicked(
        e -> {
          getScene().setRoot(new ForwardPane(player, "forward"));
        });

    actionMenu.getChildren().addAll(leftBtn, rightBtn, forwardBtn);
    setRight(actionMenu);
  }

  public void setTurnPane(Button button, AbstracPane pane) {
    button.setOnMouseClicked(
        e -> {
          getScene().setRoot(pane);
        });
  }
}
