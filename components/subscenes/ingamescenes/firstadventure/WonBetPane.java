package components.subscenes.ingamescenes.firstadventure;

import components.buttons.NextButton;
import entities.monster.Monster;
import entities.monster.MonsterFactory;
import entities.monster.MonsterType;
import entities.player.Player;

public class WonBetPane extends AbstracPane {
  public WonBetPane(Player player, String textname) {
    super(player, textname);
    NextButton nextBtn = new NextButton();
    MonsterFactory monsterFactory = new MonsterFactory();
    Monster troll = monsterFactory.createMonster(MonsterType.TROLL);

    nextBtn.setOnMouseReleased(
        e -> {
          getScene().setRoot(new FightingPane(player, troll, "trollAttacks"));
        });
    addToActionMenu(nextBtn);
  }
}
