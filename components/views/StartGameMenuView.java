package components.views;

import components.buttons.DefaultButton;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

public class StartGameMenuView implements View {
  private final VBox menu = new VBox();

  public StartGameMenuView(AnchorPane test, Scene scene) {
    DefaultButton starBtn = new DefaultButton("Start the game");
    DefaultButton exitBtn = new DefaultButton("Exit");
    DefaultButton helpBtn = new DefaultButton("Help");

    starBtn.setOnMouseClicked(e -> {
      test.getChildren().remove(menu);
      NewPlayerView newPlayerView = new NewPlayerView();
      test.getChildren().add(newPlayerView.getView());
    });

    exitBtn.setOnMouseClicked(e -> {
      System.out.println("Game terminated.");
      System.exit(0);
    });

    menu.getChildren().addAll(starBtn, helpBtn, exitBtn);
    menu.setSpacing(10);
  }

  public VBox getMenu() {
    return menu;
  }
}
