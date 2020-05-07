package components.subscenes.ingamescenes.firstadventure;

import components.actionmenu.TopMenu;
import components.buttons.DefaultButton;
import entities.player.Player;

// TODO: more generic access to texts

public class StartPane extends AbstracPane {

  public StartPane(Player player, String textname) {
    super(player, textname);
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
    addToActionMenu(leftBtn, rightBtn, forwardBtn);
  }
}
