package components.subscenes.ingamescenes.firstadventure;

import components.buttons.DefaultButton;
import components.buttons.NextButton;
import entities.monster.Monster;
import entities.player.Player;
import entities.player.PlayerBasicAttackTypes;
import javafx.scene.control.TextArea;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

// TODO: link css
// TODO: add limit for magical attacks

public class FightingPane extends AbstracPane {
  private final DefaultButton physAttack = new DefaultButton("Physical attack");
  private final DefaultButton  magAttack = new DefaultButton("Magical attack");
  private final NextButton       nextBtn = new NextButton();
  private final TextArea        textArea = new TextArea(); // Where combat actions are displayed
  private final Text            playerHP = new Text();
  private final Text            playerMP = new Text();
  private final Text           monsterHP = new Text();
  private final Font                font = new Font(24);
  public FightingPane(Player player, Monster monster, String textname) {
    super(player, textname);
    FightController fightController = new FightController(this, player, monster, textArea);

    nextBtn.setOnMouseClicked(
        e -> {
          setCenter(textArea);
          getActionMenu().getChildren().remove(nextBtn);
          addToActionMenu(physAttack, magAttack);
          playerHP.setText(fightController.formatHPString(player.getNickname(), player.getHp()));
          playerMP.setText(fightController.formatMPString());
          monsterHP.setText(fightController.formatHPString(monster.getName(), monster.getHp()));
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

    playerHP.setFont(font);
    playerMP.setFont(font);
    playerHP.setFill(Color.RED);
    playerMP.setFill(Color.BLUE);

    monsterHP.setFont(font);
    monsterHP.setFill(Color.BURLYWOOD);
    // Adding stuff to the panels
    addToActionMenu(nextBtn);
    addToBottomMenu(playerHP, playerMP, monsterHP);

    // Controllers
    fightController.physicalAttackHandler(physAttack);
    fightController.magicAttackHandler(magAttack);

    // Listening to the changes of Player and Monster health bars
    // and updating accordingly
    fightController.updatePlayer(player);
    fightController.updateMonster(monster);
  }

  public Text getPlayerHP() {
    return playerHP;
  }

  public Text getPlayerMP() { return playerMP; }

  public Text getMonsterHP() {
    return monsterHP;
  }

}
