package main;

import components.StartGameManager;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

  @Override
  public void start(Stage primaryStage) {
    StartGameManager startGameManager = new StartGameManager();
    primaryStage = startGameManager.getStage();
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
