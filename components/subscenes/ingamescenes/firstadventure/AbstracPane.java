package components.subscenes.ingamescenes.firstadventure;

import javafx.scene.layout.BorderPane;
import textfiles.TextAccessLayer;
import textfiles.TextType;

// TODO: better naming for class
// TODO: Figure out how to switch between panes without creating new object

public abstract class AbstracPane extends BorderPane {
  private boolean isVisited = false;

  public AbstracPane(String textname, TextType textType) {
    TextAccessLayer textDAO = new TextAccessLayer(textType);

    setCenter(textDAO.getText(textname));
  }

  public boolean isVisited() {
    return isVisited;
  }

  public void setVisited(boolean visited) {
    isVisited = visited;
  }
}
