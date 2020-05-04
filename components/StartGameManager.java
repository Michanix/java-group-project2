package components;

import components.buttons.DefaultButton;
import components.buttons.ExitButton;
import components.subscenes.gamemenuscenes.NewPlayerSubscene;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class StartGameManager {

  private final AnchorPane mainPane;
  private final Stage stage;

  public StartGameManager() {
    int HEIGHT = 480;
    int WIDTH = 800;
    mainPane = new AnchorPane();
    Scene scene = new Scene(mainPane, WIDTH, HEIGHT);
    stage = new Stage();
    setStarGameMenu();
    stage.setScene(scene);
    
  }

  public Stage getStage() {
    return stage;
  }

  private void setStarGameMenu() {
    DefaultButton starBtn = new DefaultButton("Start the game");
    DefaultButton helpBtn = new DefaultButton("Help");
    DefaultButton creditsBtn = new DefaultButton("Credits");
    ExitButton exitBtn = new ExitButton();
    VBox menu = new VBox();

    starBtn.setOnMouseClicked(
            e -> {
              NewPlayerSubscene newPlayerView = new NewPlayerSubscene(mainPane);
              mainPane.getChildren().add(newPlayerView);
            });

    menu.getChildren().addAll(starBtn, helpBtn, creditsBtn,exitBtn);
    menu.setSpacing(10);
    menu.setLayoutX(295);
    menu.setLayoutY(110);
    mainPane.getChildren().add(menu);
  }

  public void startGameMan(Stage currentStage) {
    currentStage.hide();
    stage.show();
  }
}
