package components.subscenes.ingamescenes.firstadventure;

import components.buttons.DefaultButton;
import components.buttons.NextButton;
import entities.monster.Monster;
import entities.player.DiceType;
import entities.player.Player;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import utils.DiceAction;


// TODO: split logic and everything else...

public class FightingPane extends AbstracPane {
  private final DefaultButton physAttack = new DefaultButton("Physical attack");
  private final DefaultButton magAttack = new DefaultButton("Magical attack");
  private final NextButton nextBtn = new NextButton();
  private final TextArea textArea = new TextArea();
  private final Player player;
  private final Monster monster;
  private String msg;

  public FightingPane(Player player, Monster monster, String textname) {
    super(player, textname);
    this.player = player;
    this.monster = monster;

    nextBtn.setOnMouseClicked(
        e -> {
          textArea.appendText("You are analysing your situation...\n");
          setCenter(textArea);
          getActionMenu().getChildren().remove(nextBtn);
          addToActionMenu(physAttack);
          addToActionMenu(magAttack);
        });

    textArea.autosize();
    textArea.setEditable(false);

    addToActionMenu(nextBtn);

    physAttackController(physAttack);
    magAttackController(magAttack);
  }

  public void physAttackController(Button physDmgBtn) {
    physDmgBtn.setOnMouseClicked(
        e -> {
          if (monster.getHp() < 0) {
            msg = "Victory!\n";
          } else if (player.getHp() < 0) {
            msg = "You died.\n";
          } else {
            int dmgDealt = calcPlayerPhysDmg();
            if (dmgDealt <= 0) {
              msg =
                  String.format(
                      "You couldn't get through %s defense.\n", monster.getClass().getSimpleName());
            } else {
              msg = String.format("You dealt %d physical damage\n", dmgDealt);
              monster.setHp(dmgDealt);
            }
          }
          textArea.appendText(msg);
        });

    physDmgBtn.setOnMouseReleased(
        e -> {
          monsterAttack();
        });
  }

  public void magAttackController(Button magDmgBtn) {
    magDmgBtn.setOnMouseClicked(
        e -> {
          if (monster.getHp() < 0) {
            msg = "Victory!\n";

          } else if (player.getHp() < 0) {
            msg = "You died.\n";
          } else {
            int dmgDealt = calcPlayerMagDmg();
            if (dmgDealt <= 0) {
              msg =
                  String.format(
                      "You couldn't get through %s defense.\n", monster.getClass().getSimpleName());
            } else {
              msg = String.format("You dealt %d magical damage\n", dmgDealt);
              monster.setHp(dmgDealt);
            }
          }
          textArea.appendText(msg);
        });

    magDmgBtn.setOnMouseReleased(
        e -> {
          monsterAttack();
        });
  }

  private void monsterAttack() {
    try {
      Thread.sleep(500);
      msg = randMonsterAttack();
    } catch (InterruptedException interruptedException) {
      interruptedException.printStackTrace();
    }
    textArea.appendText(msg);
  }
  // Two functions below calculate how much damage
  // Player dealt to Monster
  private int calcPlayerPhysDmg() {
    return player.basicPhysAttack() - monster.getPhyDef();
  }

  private int calcPlayerMagDmg() {
    return player.basicMagAttack() - monster.getMagDef();
  }

  private String randMonsterAttack() {
    /*
    Based on pure luck monster will hit the player with
    random type of attack.
     */
    int luck = DiceAction.roll2Dices(DiceType.D8);
    String monsterName = monster.getClass().getSimpleName();
    int dmg;
    String msg;
    if (luck > 50) {
      dmg = monster.basicPhysAttack() - player.getPhysDef();
      msg = String.format("%s dealt %d physical damage\n", monsterName, dmg);
    } else {
      dmg = monster.basicMagAttack() - player.getMagicDef();
      msg = String.format("%s dealt %d magical damage\n", monsterName, dmg);
    }

    if (dmg < 0) {
      msg = String.format("%s couldn't get throught your defense\n", monsterName);
    }

    player.setHp(dmg);
    return msg;
  }
}
