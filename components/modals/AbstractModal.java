package components.modals;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import utils.ReadFromFile;

import java.util.List;

public abstract class AbstractModal extends Stage {
  private final BorderPane pane = new BorderPane();

  public AbstractModal() {

    int WIDTH = 300;
    int HEIGHT = 300;

    setScene(new Scene(pane, WIDTH, HEIGHT));
    initOwner(getOwner());
    initModality(Modality.APPLICATION_MODAL);
  }

  public BorderPane getPane() {
    return pane;
  }

  public Text createText(String filename) {
    List<String> credits = ReadFromFile.readTextToList(filename);
    StringBuilder result = new StringBuilder();
    for (String txt : credits) {
      result.append(txt).append("\n");
    }
    return new Text(result.toString());
  }
}
