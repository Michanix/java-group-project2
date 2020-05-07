package components.subscenes.pregamemenupanes;

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
    List<String> credits = ReadFromFile.readTextToList("src/credits.txt");
    StringBuilder result = new StringBuilder();
    for (String txt: credits) {
      result.append(txt).append("\n");
    }
    return new Text(result.toString());
  }
}
