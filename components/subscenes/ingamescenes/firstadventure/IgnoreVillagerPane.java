package components.subscenes.ingamescenes.firstadventure;

import components.buttons.DefaultButton;
import entities.player.Player;

public class IgnoreVillagerPane extends AbstracPane {
  public IgnoreVillagerPane(Player player, String textname) {
    super(player, textname);
    DefaultButton nextBtn = new DefaultButton("Move next");

    nextBtn.setOnMouseClicked(
        e -> {
          getScene().setRoot(new GoddessEncounterPane(player, "godessEncounter"));
        });
    addToActionMenu(nextBtn);
  }
}
