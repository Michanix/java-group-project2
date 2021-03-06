package components.buttons;

import components.StartGameManager;
import javafx.stage.Stage;

public class MainMenuButton extends DefaultButton {
  public MainMenuButton() {
    super("Back to menu");
    setOnMouseClicked(
        e -> {
          StartGameManager mainMenu = new StartGameManager();
          mainMenu.startGameMan((Stage) this.getScene().getWindow());
        });
  }
}
