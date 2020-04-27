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
    System.out.println(player.getWeaponType());
    System.out.println(player.getArmorType());
    physAttack.setOnMouseClicked(
        e -> {
          int playerDmg = player.basicPhysAttack();
          int dmgDealt = playerDmg - monster.getPhyDef();
          System.out.println("-------------------");
          System.out.println("Monster phys def: "+ monster.getPhyDef());
          System.out.println("Player phys attack: " + playerDmg);
          System.out.println("Damage dealt= " + dmgDealt);
          if (dmgDealt <= 0) {
            setCenter(
                new Text(
                    String.format(
                        "You couldn't get through %s defense.",
                        monster.getClass().getSimpleName())));
          } else {
            monster.setHp(dmgDealt);
            System.out.println("Current monster hp= " + monster.getHp());
            setCenter(new Text(String.format("You dealt %d damage", dmgDealt)));
          }
        });
    addToActionMenu(nextBtn);
  }
}
