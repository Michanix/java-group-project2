package components.modals;

import javafx.scene.text.Text;

public class HelpModal extends AbstractModal {
  public HelpModal() {
    setTitle("Help");
    Text text = createText("help.txt");
    getPane().setCenter(text);
  }
}
