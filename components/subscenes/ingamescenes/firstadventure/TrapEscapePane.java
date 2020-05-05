package components.subscenes.ingamescenes.firstadventure;

import components.buttons.DefaultButton;
import components.buttons.GoBackButton;
import entities.player.Player;

public class TrapEscapePane extends AbstracPane {
  public TrapEscapePane(Player player, String textname) {
    super(player, textname);
    DefaultButton checkBtn = new DefaultButton("Check");
    GoBackButton backButton = new GoBackButton();

    checkBtn.setOnMouseClicked(
        e -> {
          getScene().setRoot(new SecretPassage(player, "armorFound"));
        });
    backButton.setOnMouseClicked(
        e -> {
          getScene().setRoot(new StartPane(player, "begining"));
        });

    addToActionMenu(checkBtn, backButton);
  }
}
