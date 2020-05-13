package components.modals;

import javafx.scene.text.Text;
import textfiles.TextAccessLayer;

public class NothingFoundModel extends AbstractModal {

  public NothingFoundModel() {
    setTitle("Nothing found");
    TextAccessLayer textAccessLayer = new TextAccessLayer();
    Text txt = textAccessLayer.getText("nothingFound");

    txt.setFont(getFont());
    getPane().setCenter(txt);
  }
}
