package components;

import components.subscenes.ingamescenes.firstadventure.StartPane;
import entities.player.Player;
import javafx.scene.Scene;
import javafx.stage.Stage;
import utils.ReadFromFile;

// TODO: better naming

public class AdventureManager {
  private final Stage mainAdventureStage = new Stage();

  public AdventureManager(Player player) {
    StartPane startMenu = new StartPane(player, "begining");
    Scene mainScene = new Scene(startMenu, 800, 480);
    mainAdventureStage.setScene(mainScene);
  }

  public void startAdventure(Stage currentStage) {
    currentStage.hide();
    mainAdventureStage.show();
  }

  public Stage getStage() {
    return mainAdventureStage;
  }
}
