package components.subscenes.ingamescenes.firstadventure;

import components.buttons.DefaultButton;
import entities.monster.Monster;
import entities.monster.MonsterFactory;
import entities.monster.MonsterType;
import entities.player.Player;

public class HelpVillagerPane extends AbstracPane {
  public HelpVillagerPane(Player player, String textname) {
    super(player, textname);
    MonsterFactory monsterFactory = new MonsterFactory();
    DefaultButton next = new DefaultButton("Next");
    next.setOnMouseClicked(
        e -> {
          Monster troll = monsterFactory.createMonster(MonsterType.TROLL);
          getScene().setRoot(new FightingPane(player, troll, "trollAttacks"));
        });
    addToActionMenu(next);
  }
}
