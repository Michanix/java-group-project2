package components.subscenes.ingamescenes.firstadventure;

import components.buttons.DefaultButton;
import entities.monster.Monster;
import entities.monster.Troll;
import entities.player.Player;

public class HelpVillagerPane extends AbstracPane {
  public HelpVillagerPane(Player player, String textname) {
    super(player, textname);
    DefaultButton next = new DefaultButton("Next");
    next.setOnMouseClicked(
        e -> {
          Monster troll = new Troll(130, 30, 30, 300);
          getScene().setRoot(new FightingPane(player, troll, "trollAttacks"));
        });
    addToActionMenu(next);
  }
}
