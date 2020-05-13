package components.modals;

import javafx.scene.text.Text;

public class SaveModel extends AbstractModal {
  public SaveModel() {
    setTitle("Save");
    setHeight(200);
    setWidth(200);

    Text msg = new Text("The player has been saved");

    msg.setFont(getFont());
    getPane().setCenter(msg);
  }
}
