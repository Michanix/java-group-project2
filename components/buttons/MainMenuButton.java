package components.buttons;

import components.StartGameManager;
import javafx.stage.Stage;

public class MainMenuButton extends DefaultButton {
  public MainMenuButton() {
    super("To main menu");
    setOnMouseClicked(
        e -> {
          StartGameManager mainMenu = new StartGameManager();
          mainMenu.startGameMan((Stage) this.getScene().getWindow());
        });
  }
}
