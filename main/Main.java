package main;

import components.StartGameManager;
import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main extends Application {

  @Override
  public void start(Stage primaryStage) throws IOException {
    StartGameManager startGameManager = new StartGameManager();
    primaryStage = startGameManager.getStage();
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
