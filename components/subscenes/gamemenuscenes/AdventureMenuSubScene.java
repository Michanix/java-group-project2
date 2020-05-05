package components.subscenes.gamemenuscenes;

import components.AdventureManager;
import components.buttons.DefaultButton;
import entities.player.Player;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class AdventureMenuSubScene extends AbstractSubScene {
  private final List<Button> advButtonList = new ArrayList<>();

  public AdventureMenuSubScene(Pane root, Player player) {
    super(root);
    AnchorPane subScene = (AnchorPane) this.getRoot();
    List<AbstractSubScene> adventureMenu = new ArrayList<>();
    createButton("1 st adventure", player);
    TilePane view = new TilePane();
    view.getChildren().addAll(advButtonList);
    view.setTileAlignment(Pos.CENTER);
    view.setHgap(5);
    view.setVgap(5);
    subScene.getChildren().add(view);
  }

  private void createButton(String name, Player player) {
    DefaultButton startLevel = new DefaultButton(name);
    startLevel.setOnMouseClicked(
        e -> {
          AdventureManager adventureManager = new AdventureManager(player);
          adventureManager.startAdventure((Stage) this.getRoot().getScene().getWindow());
        });
    advButtonList.add(startLevel);
  }
}
