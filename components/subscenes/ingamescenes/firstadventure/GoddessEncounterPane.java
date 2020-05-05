package components.subscenes.ingamescenes.firstadventure;

import components.buttons.DefaultButton;
import components.buttons.GoBackButton;
import entities.monster.Monster;
import entities.monster.MonsterFactory;
import entities.monster.MonsterType;
import entities.player.DiceType;
import entities.player.Player;
import utils.DiceAction;

public class GoddessEncounterPane extends AbstracPane {

  public GoddessEncounterPane(Player player, String textname) {
    super(player, textname);
    MonsterFactory monsterFactory = new MonsterFactory();
    DefaultButton betBtn = new DefaultButton("Bet your luck");
    GoBackButton backBtn = new GoBackButton();

    betBtn.setOnMouseClicked(
        e -> {
          int result = DiceAction.roll2Dices(DiceType.D10);
          if (result < 40) {
            Monster goddess = monsterFactory.createMonster(MonsterType.GODDESS);
            getScene().setRoot(new FightingPane(player, goddess, "goddessAttacks"));
          } else {
            getScene().setRoot(new WonBetPane(player, "wonBet"));
          }
        });

    backBtn.setOnMouseClicked(
        e -> {
          getScene().setRoot(new ForwardPane(player, "forward"));
        });

    addToActionMenu(betBtn, backBtn);
  }
}
