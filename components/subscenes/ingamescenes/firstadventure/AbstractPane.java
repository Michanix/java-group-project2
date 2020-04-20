package components.subscenes.ingamescenes.firstadventure;

import components.AdventureManager;
import components.buttons.DefaultButton;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import textfiles.TextAccessLayer;
import textfiles.TextType;

// TODO: better naming for class
// TODO: Figure out how to switch between panes without creating new object

public abstract class AbstractPane extends BorderPane {

  public AbstractPane(Stage mainStage, String textname, TextType textType) {
    TextAccessLayer textAccessLayer = new TextAccessLayer(textType);
    DefaultButton backButton = new DefaultButton("Back");
    backButton.setOnMouseClicked(
        e -> {
          backButton.getScene().setRoot(new StartPane(mainStage, "begining", TextType.FUNCTIONAL));
        });

    setBottom(backButton);
    setCenter(textAccessLayer.getText(textname));
  }
}
