package components.subscenes.ingamescenes.firstadventure;

import components.buttons.NextButton;
import entities.monster.Monster;
import entities.player.DiceType;
import entities.player.Player;
import entities.player.PlayerBasicAttackTypes;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import utils.DiceAction;

// Since this Enum only used here
// I guess, it is justified to keep it in the same file
// with controller class
enum Outcome {
  VICTORY,
  DEFEAT,
}

public class FightController {
  private FightingPane pane;
  private Player     player;
  private Monster   monster;
  private TextArea textArea;

  public FightController(FightingPane pane, Player player, Monster monster, TextArea textArea) {
    this.pane     = pane;
    this.player   = player;
    this.monster  = monster;
    this.textArea = textArea;
  }

  // 'Listening' to the change of monster HP
  // If not dead, strike back
  public void updateMonster(Monster monster) {
    monster
        .hpProperty()
        .addListener(
            (observable) -> {
              if (monster.isDead()) {
                outcome(Outcome.VICTORY);
              }
              updateHpBar(pane.getMonsterHP(), monster.getName(), monster.getHp());
            });
  }

  public void updatePlayer(Player player) {
    player
        .hpProperty()
        .addListener(
            (observableValue) -> {
              if (player.isDead()) {
                outcome(Outcome.DEFEAT);
              }
              updateHpBar(pane.getPlayerHP(), player.getNickname(), player.getHp());
            });
  }

  public void attackController(Button attackBtn, PlayerBasicAttackTypes attackType) {
    attackBtn.setOnMouseClicked(
        e -> {
          int dmg = getPlayerDmg(attackType);
          String msg;
          if (dmg <= 0) {
            msg =
                String.format(
                    "You couldn't get through %s defense.\n\n", monster.getName());
          } else {
            msg =
                String.format(
                    "You dealt %d %s damage\n\n", dmg, attackType.toString().toLowerCase());
            monster.setHp(dmg);
          }
          textArea.appendText(msg);
        });

    // Monster respond to any attack
    // In the future he might attack without waiting...who knows...
    attackBtn.setOnMouseReleased(
        e -> {
          monsterAttack();
        });
  }

  // helper functions
  // Based on outcome of a fight with a monster
  // returns specific button action
  private void outcome(Outcome outcome) {
    NextButton nextBtn = new NextButton();
    switch (outcome) {
      case VICTORY:
        player.setExp(monster.getExpPer());
        victory(nextBtn);
        break;
      case DEFEAT:
        defeat(nextBtn);
        break;
    }
    // Cleaning up ActionMenu by removing all current buttons in it
    pane.getActionMenu().getChildren().removeIf(btn -> btn instanceof Button);
    pane.getActionMenu().getChildren().add(nextBtn);
  }

  private void victory(Button btn) {
    btn.setOnMouseClicked(
        e -> {
          pane.getScene().setRoot(new EndPane(player, "trollSlayed"));
        });
  }

  private void defeat(Button btn) {
    btn.setOnMouseClicked(
        e -> {
          pane.getScene().setRoot(new EndPane(player, "playerDied"));
        });
  }

  // Function to dynamically update health points
  // Math.max() prevents to display negative amount of HP
  private void updateHpBar(Text hpBar, String name, int hp) {
    hpBar.setText(formatHPString(name, Math.max(hp, 0)));
  }

  // TODO: better name
  public String formatHPString(String name, int hp) {
    return String.format("%s HP: %d", name, hp);
  }

  private int getPlayerDmg(PlayerBasicAttackTypes attackType) {
    switch (attackType) {
      case MAGICAL:
        return calcPlayerMagDmg();
      case PHYSICAL:
        return calcPlayerPhysDmg();
      default:
        return 0;
    }
  }

  private int calcPlayerPhysDmg() {
    return player.basicPhysAttack() - monster.getPhyDef();
  }

  private int calcPlayerMagDmg() {
    return player.basicMagAttack() - monster.getMagDef();
  }

  // TODO: move into Monster class
  private void monsterAttack() {
    String msg = randMonsterAttack();
    try {
      // Slight delay to prevent spamming
      Thread.sleep(300);
    } catch (InterruptedException ex) {
      ex.getSuppressed();
    }
    textArea.appendText(msg);
  }

  private String randMonsterAttack() {
    /*
    Based on pure luck monster will hit the player with
    random type of attack.
     */
    int luck = DiceAction.roll2Dices(DiceType.D8);
    String monsterName = monster.getName();
    int dmg;
    String msg;
    if (luck > 50) {
      dmg = monster.basicPhysAttack() - player.getPhysDef();
      msg = String.format("%s dealt %d physical damage\n\n", monsterName, dmg);
    } else {
      dmg = monster.basicMagAttack() - player.getMagicDef();
      msg = String.format("%s dealt %d magical damage\n\n", monsterName, dmg);
    }

    if (dmg < 0) {
      msg =
          String.format("%s attacked you, but couldn't get through your defense\n\n", monsterName);
    } else {
      player.setHp(dmg);
    }
    return msg;
  }
}
