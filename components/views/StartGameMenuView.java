package components.views;

import components.buttons.StartMenuButton;
import javafx.scene.layout.VBox;

public class StartGameMenuView implements View {
  private final VBox menu = new VBox();

  public StartGameMenuView() {
    StartMenuButton exitBtn = new StartMenuButton("Exit");
    StartMenuButton helpBtn = new StartMenuButton("Help");
    StartMenuButton starBtn = new StartMenuButton("Start the game");

    exitBtn.setOnMouseClicked(e -> {
      System.exit(0);
    });

    menu.getChildren().addAll(starBtn, helpBtn, exitBtn);
    menu.setSpacing(10);
  }

  public VBox getMenu() {
    return menu;
  }
}
