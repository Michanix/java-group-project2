package components.subscenes.pregamemenupanes;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;

public abstract class AbstractWindow extends Stage {
  private final BorderPane pane = new BorderPane();

  public AbstractWindow() {

    int WIDTH = 300;
    int HEIGHT = 300;

    setScene(new Scene(pane, WIDTH, HEIGHT));
    initOwner(getOwner());
    initModality(Modality.APPLICATION_MODAL);
  }

  public BorderPane getPane() {
    return pane;
  }
}
