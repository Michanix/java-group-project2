package components.subscenes.gamemenuscenes;

import components.buttons.DefaultButton;
import javafx.scene.layout.Pane;

public class ChoosePlayerPane extends AbstractPreGamePane {
    private final DefaultButton newPlayerBtn  = new DefaultButton("Create new player");
    private final DefaultButton existingPlBtn = new DefaultButton("Choose existing player");

    public ChoosePlayerPane(Pane root) {

    }
}
