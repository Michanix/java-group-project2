package components.subscenes.pregamemenupanes;

import components.AdventureManager;
import components.buttons.DefaultButton;
import entities.player.Player;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.TilePane;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class AdventureMenuPane extends AbstractPreGamePane {
  private final List<Button> advButtonList = new ArrayList<>();

  public AdventureMenuPane(Player player) {
    DefaultButton startLevel = new DefaultButton("1 st adventure");

    createButton(startLevel, player);
    TilePane view = new TilePane();
    view.getChildren().addAll(advButtonList);
    view.setTileAlignment(Pos.CENTER);
    view.setHgap(5);
    view.setVgap(5);
    getChildren().add(view);
  }

  private void createButton(Button startBtn, Player player) {
    startBtn.setOnMouseClicked(
        e -> {
          AdventureManager adventureManager = new AdventureManager(player);
          adventureManager.startAdventure((Stage) this.getScene().getWindow());
        });
    advButtonList.add(startBtn);
  }
}
