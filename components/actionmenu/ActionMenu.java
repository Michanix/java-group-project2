package components.actionmenu;

import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

/*
Menu to display set of action available to player during the game
 */

public class ActionMenu extends VBox {
    public ActionMenu() {
        setSpacing(10);
        Label label = new Label("Actions");
        getChildren().add(label);
    }
}
