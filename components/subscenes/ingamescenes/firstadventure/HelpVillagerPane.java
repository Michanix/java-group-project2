package components.subscenes.ingamescenes.firstadventure;

import components.buttons.DefaultButton;
import entities.player.Player;

public class HelpVillagerPane extends AbstracPane {
  public HelpVillagerPane(Player player, String textname) {
    super(player, textname);
    DefaultButton next = new DefaultButton("Next");
    next.setOnMouseClicked(
        e -> {
          getScene().setRoot(new FightTheTrollPane(player, "trollAttacks"));
        });
    addToActionMenu(next);
  }
}
