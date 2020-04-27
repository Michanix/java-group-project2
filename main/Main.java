package main;

import components.AdventureManager;
import components.StartGameManager;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

  @Override
  public void start(Stage primaryStage) {
    StartGameManager startGameManager = new StartGameManager();
    AdventureManager adventureManager = new AdventureManager();
    primaryStage = startGameManager.getStage();
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
