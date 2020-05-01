package components.subscenes.ingamescenes.firstadventure;

import components.buttons.DefaultButton;
import entities.monster.Monster;
import entities.player.Player;
import javafx.scene.control.TextArea;

// TODO: refactor calculating values for damage
// TODO: refactoring - Extract Functions

public class FightingPane extends AbstracPane {
  private final DefaultButton physAttack = new DefaultButton("Physical attack");
  private final DefaultButton magAttack = new DefaultButton("Magical attack");
  private final DefaultButton nextBtn = new DefaultButton("Next");
  private final FightPaneController fightController = new FightPaneController();

  public FightingPane(Player player, Monster monster, String textname) {
    super(player, textname);
    TextArea textArea = new TextArea();
    nextBtn.setOnMouseClicked(
        e -> {
          textArea.appendText("You are analysing your situation...\n");
          getActionMenu().getChildren().remove(nextBtn);
          addToActionMenu(physAttack);
          addToActionMenu(magAttack);
        });
    System.out.println(player.getWeaponType());
    System.out.println(player.getArmorType());

    fightController.physAttackController(physAttack, player, monster, textArea);
    fightController.magAttackController(magAttack, player, monster, textArea);

    textArea.autosize();
    textArea.setEditable(false);
    setCenter(textArea);
    addToActionMenu(nextBtn);
  }
}
