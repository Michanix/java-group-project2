package components.subscenes.ingamescenes.firstadventure;

import entities.player.WeaponType;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import textfiles.TextType;
import utils.GetRandomType;

public class LeftTurnPane extends AbstracPane {
  public LeftTurnPane(Stage mainStage, String textname, TextType textType) {
    super(mainStage, textname, textType);

    WeaponType rndWeapon = GetRandomType.randomEnum(WeaponType.class);
    setRight(new Text(String.format("You got %s", rndWeapon.toString())));
  }
}
