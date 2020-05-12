package components.subscenes.ingamescenes.firstadventure;

import components.buttons.NextButton;
import entities.player.Player;

public class IgnoreVillagerPane extends AbstracPane {
  public IgnoreVillagerPane(Player player, String textname) {
    super(player, textname);
    NextButton nextBtn = new NextButton();

    nextBtn.setOnMouseClicked(
        e -> {
          getScene().setRoot(new GoddessEncounterPane(player, "godessEncounter"));
        });
    addToActionMenu(nextBtn);
  }
}
