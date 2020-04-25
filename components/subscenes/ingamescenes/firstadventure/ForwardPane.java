package components.subscenes.ingamescenes.firstadventure;

import components.buttons.DefaultButton;
import entities.player.Player;

public class ForwardPane extends AbstracPane {

  public ForwardPane(Player player, String textname) {
    super(player, textname);
    DefaultButton agreeBtn = new DefaultButton("Yes, I agree");
    DefaultButton ignoreBtn = new DefaultButton("Ignore the villager");
    ignoreBtn.setOnMouseClicked(
        e -> {
          getScene().setRoot(new IgnoreVillagerPane(player, "ignoreVillager"));
        });
  }
}
