package components.subscenes.ingamescenes.firstadventure;

import components.buttons.DefaultButton;
import components.buttons.GoBackButton;
import entities.monster.Goddess;
import entities.monster.Monster;
import entities.player.DiceType;
import entities.player.Player;
import utils.DiceAction;

public class GoddessEncounterPane extends AbstracPane {

  public GoddessEncounterPane(Player player, String textname) {
    super(player, textname);
    DefaultButton betBtn = new DefaultButton("Bet your luck");
    GoBackButton backBtn = new GoBackButton();
    betBtn.setOnMouseClicked(
        e -> {
          int result = DiceAction.roll2Dices(DiceType.D10);
          if (result < 60) {
              Monster goddess = new Goddess(200, 55, 60, 1000);
            getScene().setRoot(new FightingPane(player, goddess,"goddessAttacks"));
          } else {
            System.out.println("you won and she let you live");
          }
        });

    backBtn.setOnMouseClicked(
        e -> {
          getScene().setRoot(new ForwardPane(player, "forward"));
        });

    addToActionMenu(betBtn);
    addToActionMenu(backBtn);
  }
}
