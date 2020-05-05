package components.subscenes.gamemenuscenes;

import javafx.scene.SubScene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

public abstract class AbstractSubScene extends SubScene {
  public AbstractSubScene(Pane root) {
    super(new AnchorPane(), root.getWidth(), root.getHeight());
  }
}
