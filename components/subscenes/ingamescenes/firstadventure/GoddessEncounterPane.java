package components.subscenes.ingamescenes.firstadventure;

import components.buttons.DefaultButton;
import entities.player.Player;

public class GoddessEncounterPane extends AbstracPane {

  public GoddessEncounterPane(Player player, String textname) {
    super(player, textname);
    DefaultButton betBtn = new DefaultButton("Bet your luck");
    DefaultButton backToVillageBtn = new DefaultButton("Back to the village");
  }
}
