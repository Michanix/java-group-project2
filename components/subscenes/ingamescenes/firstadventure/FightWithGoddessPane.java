package components.subscenes.ingamescenes.firstadventure;

import entities.monster.Goddess;
import entities.player.Player;

public class FightWithGoddessPane extends AbstracPane {
  public FightWithGoddessPane(Player player, String textname) {
    super(player, textname);
    Goddess goddess = new Goddess(200, 45, 70, 50, 75, 1000);
  }
}
