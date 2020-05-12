package components.modals;

import javafx.scene.text.Text;
import utils.ReadFromFile;

import java.util.List;

public class CreditsModal extends AbstractModal {
  public CreditsModal() {
    setTitle("Credits");
    Text texts = createText("credits.txt");
    getPane().setCenter(texts);
  }
}
