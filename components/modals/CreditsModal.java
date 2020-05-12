package components.modals;

import javafx.scene.text.Text;
import utils.ReadFromFile;

import java.util.List;

public class CreditsModal extends AbstractModal {
  public CreditsModal() {
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
