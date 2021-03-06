package components;

import components.buttons.CreditsButton;
import components.buttons.DefaultButton;
import components.buttons.ExitButton;
import components.buttons.HelpButton;
import components.subscenes.pregamemenupanes.ManagePlayersPane;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class StartGameManager {

  private final AnchorPane mainPane;
  private final Stage stage;

  public StartGameManager() {
    int WIDTH   = 800;
    int HEIGHT  = 480;
    mainPane    = new AnchorPane();
    Scene scene = new Scene(mainPane, WIDTH, HEIGHT);
    stage       = new Stage();

    setStarGameMenu();
    stage.setScene(scene);
  }

  public Stage getStage() {
    return stage;
  }

  private void setStarGameMenu() {
    DefaultButton starBtn    = new DefaultButton("Start the game");
    HelpButton helpBtn       = new HelpButton();
    CreditsButton creditsBtn = new CreditsButton();
    ExitButton exitBtn       = new ExitButton();
    VBox menu                = new VBox();

    starBtn.setOnMouseClicked(
        e -> {
          ManagePlayersPane choiceMenu = new ManagePlayersPane();
          mainPane.getScene().setRoot(choiceMenu);
        });

    menu.getChildren().addAll(starBtn, helpBtn, creditsBtn, exitBtn);
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
