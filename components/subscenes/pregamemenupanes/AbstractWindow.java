package components.subscenes.pregamemenupanes;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public class AbstractWindow extends Stage {

    public AbstractWindow(String title) {
        setTitle(title);

        int WIDTH = 300;
        int HEIGHT = 200;
        BorderPane pane = new BorderPane();

        setScene(new Scene(pane, WIDTH, HEIGHT));
        initOwner(getOwner());
        initModality(Modality.APPLICATION_MODAL);
    }
}
