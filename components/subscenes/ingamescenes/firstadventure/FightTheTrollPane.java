package components.subscenes.ingamescenes.firstadventure;

import components.buttons.DefaultButton;
import entities.player.Player;
import javafx.scene.text.Text;

public class FightTheTrollPane extends AbstracPane {
  public FightTheTrollPane(Player player, String textname) {
    super(player, textname);
    DefaultButton nextBtn = new DefaultButton("Next");
    nextBtn.setOnMouseClicked(
        e -> {
          setCenter(new Text("You are analysing your situation..."));
          getActionMenu().getChildren().remove(nextBtn);
        });
    addToActionMenu(nextBtn);

  }
}
