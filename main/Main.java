package main;

import components.StartGameManager;
import javafx.application.Application;
import javafx.stage.Stage;
import utils.WriteToFile;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class Main extends Application {

  @Override
  public void start(Stage primaryStage) throws IOException {
    StartGameManager startGameManager = new StartGameManager();
    primaryStage = startGameManager.getStage();
    primaryStage.show();
  }

  public static void main(String[] args) {
    // Checking if file 'players.txt' already exists
    // If not then creates such file that acts as a local database.
    WriteToFile.check();
    launch(args);
  }
}