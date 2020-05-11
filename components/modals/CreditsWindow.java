package components.modals;

import components.subscenes.pregamemenupanes.AbstractWindow;
import javafx.scene.text.Text;
import utils.ReadFromFile;

import java.util.List;

public class CreditsWindow extends AbstractWindow {
  public CreditsWindow() {
    setTitle("Credits");
    Text texts = createCreditsText();
    getPane().setCenter(texts);
  }

  private Text createCreditsText() {
    List<String> credits = ReadFromFile.readTextToList("credits.txt");
    StringBuilder result = new StringBuilder();
    for (String txt : credits) {
      result.append(txt).append("\n");
    }
    return new Text(result.toString());
  }
}
