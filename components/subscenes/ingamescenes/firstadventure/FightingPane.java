package components.subscenes.ingamescenes.firstadventure;

import components.buttons.DefaultButton;
import components.buttons.NextButton;
import entities.monster.Monster;
import entities.player.DiceType;
import entities.player.Player;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import utils.DiceAction;

// TODO: split logic and everything else...
// TODO: link css
// TODO: add limit for magical attacks
// Attention! Spaghetti code below!

public class FightingPane extends AbstracPane {
  private final DefaultButton physAttack = new DefaultButton("Physical attack");
  private final DefaultButton magAttack = new DefaultButton("Magical attack");
  private final NextButton nextBtn = new NextButton();
  private final TextArea textArea = new TextArea(); // Where combat actions are displayed
  private final Player player;
  private final Monster monster;
  private final Text playerHP = new Text();
  private final Text monsterHP = new Text();
  // private String msg; // Message that is being displayed

  public FightingPane(Player player, Monster monster, String textname) {
    super(player, textname);
    this.player = player;
    this.monster = monster;

    nextBtn.setOnMouseClicked(
        e -> {
          textArea.appendText(
              String.format("%s strikes first...\n\n", monster.getClass().getSimpleName()));
          setCenter(textArea);
          getActionMenu().getChildren().remove(nextBtn);
          addToActionMenu(physAttack);
          addToActionMenu(magAttack);
        });

    // styling
    textArea.setMaxSize(450, 300);
    textArea.setWrapText(true);
    textArea.setEditable(false);
    textArea.setStyle(
        "-fx-font-family: Roboto;"
            + "-fx-font-size: 14px;"
            + "-fx-background-color: blue;"
            + "-fx-control-inner-background: #87ccbe;");

    playerHP.setFont(new Font(24));
    playerHP.setFill(Color.BLUE);

    monsterHP.setFont(new Font(24));
    monsterHP.setFill(Color.RED);

    // Adding stuff to the panels
    addToActionMenu(nextBtn);
    addToBottomMenu(playerHP, monsterHP);

    monster
        .hpProperty()
        .addListener(
            (observable) -> {
              if (monster.isDead()) {
                textArea.setText("Victory!\n");
                victory();
              } else {
                monsterAttack();
              }
            });
    player
        .hpProperty()
        .addListener(
            (observableValue) -> {
              if (player.isDead()) {
                textArea.setText("You died.\n");
                defeat();
              }
            });

    physAttackController(physAttack);
    magAttackController(magAttack);
  }

  // TODO: Create Enum for basic player attack types?
  public void physAttackController(Button physDmgBtn) {
    physDmgBtn.setOnMouseClicked(
        e -> {
          int dmgDealt = calcPlayerPhysDmg();
          String msg;
          if (dmgDealt <= 0) {
            msg =
                String.format(
                    "You couldn't get through %s defense.\n\n", monster.getClass().getSimpleName());
          } else {
            msg = String.format("You dealt %d physical damage\n\n", dmgDealt);
            monster.setHp(dmgDealt);
          }
          updateMonsterHp();
          textArea.appendText(msg);
        });
  }

  public void magAttackController(Button magDmgBtn) {
    magDmgBtn.setOnMouseClicked(
        e -> {
          int dmgDealt = calcPlayerMagDmg();
          String msg;
          if (dmgDealt <= 0) {
            msg =
                String.format(
                    "You couldn't get through %s defense.\n\n", monster.getClass().getSimpleName());
          } else {
            msg = String.format("You dealt %d magical damage\n\n", dmgDealt);
            monster.setHp(dmgDealt);
          }
          updateMonsterHp();
          textArea.appendText(msg);
        });
  }


  // TODO: turn into one parametrize function
  // helper functions
  private void victory() {
    player.setExp(monster.getExpPer());
    DefaultButton next2 = new DefaultButton("Next");
    next2.setOnMouseClicked(
        e -> {
          getScene().setRoot(new EndPane(player, "trollSlayed"));
        });
    getActionMenu().getChildren().removeAll(physAttack, magAttack);
    getActionMenu().getChildren().add(next2);
  }

  private void defeat() {
    DefaultButton next2 = new DefaultButton("Next");
    next2.setOnMouseClicked(
        e -> {
          getScene().setRoot(new EndPane(player, "playerDied"));
        });
    getActionMenu().getChildren().removeAll(physAttack, magAttack);
    getActionMenu().getChildren().add(next2);
  }

  private void updatePlayerHp() {
    int hp = Math.max(player.getHp(), 0); // Little hack to display zero instead of negative hp
    playerHP.setText(String.format("%s HP: %d", player.getNickname(), hp));
  }

  private void updateMonsterHp() {
    int hp = Math.max(monster.getHp(), 0);
    monsterHP.setText(String.format("%s HP: %d", monster.getClass().getSimpleName(), hp));
  }

  private void monsterAttack() {
    String msg = randMonsterAttack();
    try {
      Thread.sleep(500);
    } catch (InterruptedException ex) {
      ex.getSuppressed();
    }
    updatePlayerHp();
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

  // TODO: move into Monster class
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
