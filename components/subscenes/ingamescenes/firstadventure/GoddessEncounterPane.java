package components.subscenes.ingamescenes.firstadventure;

import components.buttons.DefaultButton;
import components.buttons.GoBackButton;
import entities.player.Player;

public class GoddessEncounterPane extends AbstracPane {

  public GoddessEncounterPane(Player player, String textname) {
    super(player, textname);
    DefaultButton betBtn = new DefaultButton("Bet your luck");
    GoBackButton backBtn = new GoBackButton();


    addToActionMenu(betBtn);
    addToActionMenu(backBtn);
  }
}
