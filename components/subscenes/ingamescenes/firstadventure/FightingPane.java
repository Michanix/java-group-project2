package components.subscenes.ingamescenes.firstadventure;

import components.buttons.DefaultButton;
import entities.monster.Monster;
import entities.player.Player;
import javafx.scene.control.TextArea;

// TODO: refactor calculating values for damage

public class FightingPane extends AbstracPane {
  private final DefaultButton physAttack = new DefaultButton("Physical attack");
  private final DefaultButton nextBtn = new DefaultButton("Next");

  public FightingPane(Player player, Monster monster, String textname) {
    super(player, textname);
    TextArea textArea = new TextArea();
    nextBtn.setOnMouseClicked(
        e -> {
          textArea.appendText("You are analysing your situation...\n");
          getActionMenu().getChildren().remove(nextBtn);
          addToActionMenu(physAttack);
        });
    System.out.println(player.getWeaponType());
    System.out.println(player.getArmorType());
    physAttack.setOnMouseClicked(
        e -> {
          int playerDmg = player.basicPhysAttack();
          int dmgDealt = playerDmg - monster.getPhyDef();
          String msg;
          System.out.println("-------------------");
          System.out.println("Monster phys def: " + monster.getPhyDef());
          System.out.println("Player phys attack: " + playerDmg);
          System.out.println("Damage dealt= " + dmgDealt);
          if (dmgDealt <= 0) {
            msg =
                String.format(
                    "You couldn't get through %s defense.\n", monster.getClass().getSimpleName());
          } else {
            monster.setHp(dmgDealt);
            System.out.println("Current monster hp= " + monster.getHp());
            msg = String.format("You dealt %d damage\n", dmgDealt);
          }
          textArea.appendText(msg);
        });
    textArea.autosize();
    textArea.setEditable(false);
    setCenter(textArea);
    addToActionMenu(nextBtn);
  }
}
