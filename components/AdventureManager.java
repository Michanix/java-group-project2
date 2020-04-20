package components;

import components.subscenes.ingamescenes.firstadventure.StartPane;
import javafx.scene.Scene;
import javafx.stage.Stage;
import textfiles.TextType;

// TODO: better naming

public class AdventureManager {
  private final Stage mainAdventureStage = new Stage();

  public AdventureManager() {
    StartPane startMenu = new StartPane(mainAdventureStage, "begining", TextType.FUNCTIONAL);
    Scene mainScene = new Scene(startMenu, 600, 480);
    mainAdventureStage.setScene(mainScene);
  }

  public void startAdventure(Stage currentStage) {
    currentStage.hide();
    mainAdventureStage.show();
  }

  public Stage getMainAdventureStage() {
    return mainAdventureStage;
  }
}
