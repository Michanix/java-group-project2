package components.modals;

import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import utils.ReadFromFile;

import java.util.List;

/*
Class to create Modal windows.
 */

public abstract class AbstractModal extends Stage {
  private final BorderPane pane = new BorderPane();
  private final Font font       = Font.font(16);

  public AbstractModal() {

    int WIDTH   = 400;
    int HEIGHT  = 300;

    setMaximized(false);
    setMaxWidth(WIDTH);
    setMaxHeight(HEIGHT);

    setScene(new Scene(pane, WIDTH, HEIGHT));
    initOwner(getOwner());
    initModality(Modality.APPLICATION_MODAL);
  }

  // This functions read text files from 'text database'
  // and create Text node that is later can be display in Modal window
  public Text createText(String filename) {
    List<String> credits = ReadFromFile.readTextToList(filename);
    StringBuilder result = new StringBuilder();
    for (String txt : credits) {
      result.append(txt).append("\n");
    }
    return new Text(result.toString());
  }

  // getters
  public BorderPane getPane() {
    return pane;
  }

  public Font getFont() { return font; }
}
