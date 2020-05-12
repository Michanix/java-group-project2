package components.subscenes.ingamescenes.firstadventure;

import components.StartGameManager;
import components.buttons.ExitButton;
import components.buttons.NextButton;
import entities.player.Player;
import javafx.stage.Stage;

/*
Pane that is showed player at the end of the adventure.
Depends on his 'destiny', according text will be shown.
 */

public class EndPane extends AbstracPane {
  public EndPane(Player player, String textname) {
    super(player, textname);
    NextButton nextBtn = new NextButton();
    ExitButton exitBtn = new ExitButton();

    nextBtn.setOnMouseClicked(
        e -> {
          StartGameManager startGameManager = new StartGameManager();
          startGameManager.startGameMan((Stage) this.getScene().getWindow());
        });

    addToActionMenu(nextBtn, exitBtn);
  }
}
