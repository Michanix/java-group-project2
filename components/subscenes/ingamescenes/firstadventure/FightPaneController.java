package components.subscenes.ingamescenes.firstadventure;

import entities.monster.Monster;
import entities.player.Player;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;

public class FightPaneController {

  public void physAttackController(
      Button physAttackBtn, Player player,
      Monster monster, TextArea textArea) {
    physAttackBtn.setOnMouseClicked(
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

  public void magAttackController(
      Button magAttackBtn, Player player,
      Monster monster, TextArea textArea) {
    magAttackBtn.setOnMouseClicked(
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
