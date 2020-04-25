package components.subscenes.ingamescenes.firstadventure;

import components.actionmenu.ActionMenu;
import entities.player.Player;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import textfiles.TextAccessLayer;

// TODO: better naming for class
// TODO: Figure out how to switch between panes without creating new object

public abstract class AbstracPane extends BorderPane {
  private final ActionMenu actionMenu = new ActionMenu();

  public AbstracPane(Player player, String textname) {
    TextAccessLayer textDAO = new TextAccessLayer("src/textfiles/firstadventure/texts");

    setCenter(textDAO.getText(textname));
    setRight(actionMenu);
  }

  public void addToActionMenu(Node node) {
    actionMenu.getChildren().add(node);
  }

  public ActionMenu getActionMenu() {
    return actionMenu;
  }
}
