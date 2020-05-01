package components.subscenes.ingamescenes.firstadventure;

import entities.monster.Monster;
import entities.player.Player;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;


public class FightPaneController {
  private final Monster monster;
  private final Player   player;

  public FightPaneController(Monster monster, Player player) {
    this.monster = monster;
    this.player = player;
  }

  public void physAttackController(Button physDmgBtn, TextArea textArea) {
    physDmgBtn.setOnMouseClicked(
        e -> {
          int playerDmg = player.basicPhysAttack();
          int dmgDealt = playerDmg - monster.getPhyDef();
          String msg; // Displayed message in TextArea
          if (dmgDealt <= 0) {
            msg =
                String.format(
                    "You couldn't get through %s defense.\n", monster.getClass().getSimpleName());
          } else {
            monster.setHp(dmgDealt);
            msg = String.format("You dealt %d physical damage\n", dmgDealt);
          }
          textArea.appendText(msg);
        });
  }

  public void magAttackController(Button magDmgBtn, TextArea textArea) {
    magDmgBtn.setOnMouseClicked(
        e -> {
          int playerDmg = player.basicMagAttack();
          int dmgDealt = playerDmg - monster.getMagDef();
          String msg; // Displayed message in TextArea
          if (dmgDealt <= 0) {
            msg =
                String.format(
                    "You couldn't get through %s defense.\n", monster.getClass().getSimpleName());
          } else {
            monster.setHp(dmgDealt);
            msg = String.format("You dealt %d magical damage\n", dmgDealt);
          }
          textArea.appendText(msg);
        });
  }
}
