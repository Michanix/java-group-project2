package components.subscenes.gamemenuscenes;

import components.AdventureManager;
import components.buttons.DefaultButton;
import entities.player.Player;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class AdventureMenuPreGamePane extends AbstractPreGamePane {
  private final List<Button> advButtonList = new ArrayList<>();

  public AdventureMenuPreGamePane(Player player) {
    createButton(player);
    TilePane view = new TilePane();
    view.getChildren().addAll(advButtonList);
    view.setTileAlignment(Pos.CENTER);
    view.setHgap(5);
    view.setVgap(5);
    getChildren().add(view);
  }

  private void createButton(Player player) {
    DefaultButton startLevel = new DefaultButton("1 st adventure");
    startLevel.setOnMouseClicked(
        e -> {
          AdventureManager adventureManager = new AdventureManager(player);
          adventureManager.startAdventure((Stage) this.getScene().getWindow());
        });
    advButtonList.add(startLevel);
  }
}
