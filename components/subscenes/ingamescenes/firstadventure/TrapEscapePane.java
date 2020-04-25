package components.subscenes.ingamescenes.firstadventure;

import components.buttons.DefaultButton;
import entities.player.Player;

public class TrapEscapePane extends AbstracPane {
  public TrapEscapePane(Player player, String textname) {
    super(player, textname);
    DefaultButton checkBtn = new DefaultButton("Check");
    checkBtn.setOnMouseClicked(
        e -> {
          getScene().setRoot(new SecretPassage(player, "armorFound"));
        });
    DefaultButton backButton = new DefaultButton("Back");
    backButton.setOnMouseClicked(
        e -> {
          getScene().setRoot(new StartPane(player, "begining"));
        });
    addToActionMenu(checkBtn);
    addToActionMenu(backButton);
  }
}
