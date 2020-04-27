package components.subscenes.ingamescenes.firstadventure;

import components.buttons.DefaultButton;
import entities.monster.Monster;
import entities.player.Player;
import javafx.scene.text.Text;

// TODO: refactor calculating values for damage

public class FightingPane extends AbstracPane {
  public FightingPane(Player player, Monster monster, String textname) {
    super(player, textname);
    DefaultButton physAttack = new DefaultButton("Physical attack");
    DefaultButton nextBtn = new DefaultButton("Next");
    nextBtn.setOnMouseClicked(
        e -> {
          setCenter(new Text("You are analysing your situation..."));
          getActionMenu().getChildren().remove(nextBtn);
          addToActionMenu(physAttack);
        });

    physAttack.setOnMouseClicked(
        e -> {
          int hp = monster.getHp();
          int dmgDealt = monster.getPhyDef() - player.basicPhysAttack();
          if (dmgDealt < 0) {
            setCenter(
                new Text(
                    String.format(
                        "You couldn't get through %s defense.",
                        monster.getClass().getSimpleName())));
          } else {
            monster.setHp(dmgDealt);
            setCenter(new Text(String.format("You dealt %d damage", dmgDealt)));
          }
          System.out.println("Current monster hp= " + hp);
        });
    addToActionMenu(nextBtn);
  }
}
