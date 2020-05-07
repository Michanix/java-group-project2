package components.subscenes.ingamescenes.firstadventure;

import components.actionmenu.ActionMenu;
import components.actionmenu.BottomMenu;
import components.actionmenu.InGameTopMenu;
import entities.player.Player;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import textfiles.TextAccessLayer;

// TODO: better naming for class
// TODO: Figure out how to switch between panes without creating new object

public abstract class AbstracPane extends BorderPane {
  private final ActionMenu actionMenu = new ActionMenu();
  private final BottomMenu bottomMenu = new BottomMenu();

  public AbstracPane(Player player, String textname) {
    TextAccessLayer textDAO = new TextAccessLayer("src/textfiles/firstadventure/texts");
    InGameTopMenu inGameTopMenu = new InGameTopMenu(player);

    setCenter(textDAO.getText(textname));
    setRight(actionMenu);
    setBottom(bottomMenu);
    setTop(inGameTopMenu);
  }

  public void addToActionMenu(Node... node) {
    actionMenu.getChildren().addAll(node);
  }

  public void addToBottomMenu(Node... node) {
    bottomMenu.getChildren().addAll(node);
  }

  public ActionMenu getActionMenu() {
    return actionMenu;
  }
}
