package components.subscenes.ingamescenes.firstadventure;

import components.buttons.DefaultButton;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import textfiles.TextAccessLayer;
import textfiles.TextType;

// TODO: better naming for class
// TODO: Figure out how to switch between panes without creating new object

public abstract class AbstracPane extends BorderPane {
  private boolean isVisited = false;

  public AbstracPane(Stage mainStage, String textname, TextType textType) {
    TextAccessLayer textDAO = new TextAccessLayer(textType);
    DefaultButton backButton = new DefaultButton("Back");

    backButton.setOnMouseClicked(
        e -> {
          // backButton.getScene().setRoot(mainStage.getScene().getRoot());
        });

    setBottom(backButton);
    setCenter(textDAO.getText(textname));
  }

  public boolean isVisited() {
    return isVisited;
  }

  public void setVisited(boolean visited) {
    isVisited = visited;
  }
}
