package components.modals;

import javafx.geometry.Pos;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import textfiles.TextAccessLayer;

public class ArteFoundModal extends AbstractModal {
  public ArteFoundModal(String filename, String arteName, int artePhyParam, int arteMagParam) {
    setTitle("Artifact found");
    TextAccessLayer textAccessLayer = new TextAccessLayer();
    VBox vBox = new VBox();
    Text txt = textAccessLayer.getText(filename);
    Text arte =
        new Text(
            String.format(
                "You now have %s. \n"
                    + "Your physical stats increased by %d. \n"
                    + "Your magical stats increased by %d",
                arteName, artePhyParam, arteMagParam));

    arte.setFont(new Font(16));
    vBox.getChildren().addAll(txt, arte);
    vBox.setAlignment(Pos.CENTER);
    getPane().setCenter(vBox);
  }
}
