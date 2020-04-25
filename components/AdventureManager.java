package components;

import components.subscenes.ingamescenes.firstadventure.StartPane;
import entities.player.ArmorType;
import entities.player.Player;
import entities.player.RaceType;
import javafx.scene.Scene;
import javafx.stage.Stage;
import textfiles.TextType;

// TODO: better naming

public class AdventureManager {
  private final Stage mainAdventureStage = new Stage();
  private Player player = Player.createNewPlayer(
          "mihhail", RaceType.BARBARIAN, ArmorType.HEAVYARMOR
  );
  public AdventureManager() {
    StartPane startMenu = new StartPane(player, "begining", TextType.FUNCTIONAL);
    Scene mainScene = new Scene(startMenu, 600, 480);
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
