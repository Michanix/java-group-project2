package components.subscenes.ingamescenes.firstadventure;

import components.buttons.DefaultButton;
import components.buttons.NextButton;
import entities.monster.Monster;
import entities.player.DiceType;
import entities.player.Player;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import utils.DiceAction;

public class FightingPane extends AbstracPane {
  private final DefaultButton physAttack = new DefaultButton("Physical attack");
  private final DefaultButton magAttack = new DefaultButton("Magical attack");
  private final NextButton nextBtn = new NextButton();
  private final TextArea textArea = new TextArea();
  private Player player;
  private Monster monster;
  private String msg;

  public FightingPane(Player player, Monster monster, String textname) {
    super(player, textname);
    this.player = player;
    this.monster = monster;

    nextBtn.setOnMouseClicked(
        e -> {
          textArea.appendText("You are analysing your situation...\n");
          getActionMenu().getChildren().remove(nextBtn);
          addToActionMenu(physAttack);
          addToActionMenu(magAttack);
        });

    System.out.println(player.getWeaponType());
    System.out.println(player.getArmorType());
    setCenter(textArea);
    textArea.autosize();
    textArea.setEditable(false);

    addToActionMenu(nextBtn);

    physAttackController(physAttack);
    magAttackController(magAttack);
    if (monster.getHp() < 0) {
        System.out.println("died");
    }
  }

  public void physAttackController(Button physDmgBtn) {
    physDmgBtn.setOnMouseClicked(
        e -> {
          int dmgDealt = calcPlayerPhysDmg();
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

  public void magAttackController(Button magDmgBtn) {
    magDmgBtn.setOnMouseClicked(
        e -> {
          int dmgDealt = calcPlayerMagDmg();
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

    magDmgBtn.setOnMouseReleased(
        e -> {
          if (monster.getHp() < 0) {
            getScene().setRoot(new EndPane(player, "ifBeastSlayed"));
          } else if (player.getHp() < 0) {
            getScene().setRoot(new EndPane(player, "playerDied"));
          } else {
            textArea.appendText(randMonsterAttack());
          }
        });
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
    int dmg;
    String msg;
    if (luck > 50) {
      dmg = monster.basicPhysAttack() - player.getPhysDef();
      msg = String.format("%s dealt %d physical damage\n", monster.getClass().getSimpleName(), dmg);
    } else {
      dmg = monster.basicMagAttack() - player.getMagicDef();
      msg = String.format("%s dealt %d magical damage\n", monster.getClass().getSimpleName(), dmg);
    }
    player.setHp(dmg);
    return msg;
  }
}
