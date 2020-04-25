package components.subscenes.ingamescenes.firstadventure;

import components.actionmenu.ActionMenu;
import components.buttons.DefaultButton;
import entities.player.Player;
import textfiles.TextType;

public class TrapEscapePane extends AbstracPane {
  public TrapEscapePane(Player player, String textname, TextType textType) {
    super(textname, textType);
    DefaultButton checkBtn = new DefaultButton("Check");
    ActionMenu actionMenu = new ActionMenu();
    checkBtn.setOnMouseClicked(
        e -> {
          getScene().setRoot(new SecretPassage(player, "armorFound", TextType.REGULAR));
        });
    DefaultButton backButton = new DefaultButton("Back");
    backButton.setOnMouseClicked(
        e -> {
          getScene().setRoot(new StartPane(player, "begining", TextType.FUNCTIONAL));
        });
    actionMenu.getChildren().addAll(checkBtn, backButton);
    setRight(actionMenu);
  }
}
