package components.subscenes.ingamescenes.firstadventure;

import components.actionmenu.ActionMenu;
import components.actionmenu.BottomMenu;
import components.actionmenu.InGameTopMenu;
import entities.player.Player;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import textfiles.TextAccessLayer;

// TODO: better naming for class

public abstract class AbstracPane extends BorderPane {
  private final ActionMenu actionMenu = new ActionMenu();
  private final BottomMenu bottomMenu = new BottomMenu();

  public AbstracPane(Player player, String textname) {
    TextAccessLayer accessText = new TextAccessLayer();
    InGameTopMenu inGameTopMenu = new InGameTopMenu(player);
    Text txt = accessText.getText(textname);
    txt.setFont(Font.font(16));
    setCenter(txt);
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
