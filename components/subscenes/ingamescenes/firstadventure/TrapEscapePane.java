package components.subscenes.ingamescenes.firstadventure;

import components.buttons.DefaultButton;
import entities.player.Player;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import textfiles.TextType;

public class TrapEscapePane extends AbstracPane {
  public TrapEscapePane(Player player, String textname, TextType textType) {
    super(textname, textType);
    DefaultButton checkBtn = new DefaultButton("Check");
    Label actionsL = new Label("Actions");
    VBox actionMenu = new VBox(10);
    checkBtn.setOnMouseClicked(
        e -> {
          getScene().setRoot(new SecretPassage(player, "armorFound", TextType.REGULAR));
        });
    actionMenu.getChildren().addAll(actionsL, checkBtn);
    setRight(actionMenu);
  }
}
