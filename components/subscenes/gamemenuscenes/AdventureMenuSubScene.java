package components.subscenes.gamemenuscenes;

import components.buttons.DefaultButton;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;

import java.util.ArrayList;
import java.util.List;

public class AdventureMenuSubScene extends AbstractSubScene {
  private final AnchorPane subScene;
  private final TilePane view = new TilePane();
  private final List<Button> advButtonList = new ArrayList<>();

  public AdventureMenuSubScene(Pane root) {
    super(root);
    subScene = (AnchorPane) this.getRoot();
    List<AbstractSubScene> adventureMenu = new ArrayList<>();
    createButton("1 st adventure", null);
    view.getChildren().addAll(advButtonList);
    view.setTileAlignment(Pos.CENTER);
    view.setHgap(5);
    view.setVgap(5);
    subScene.getChildren().add(view);
  }

  private void createButton(String name, AbstractSubScene level) {
    DefaultButton startLevel = new DefaultButton(name);
    startLevel.setOnMouseClicked(e ->{
      //level.start();
    });
    advButtonList.add(startLevel);
  }
}
