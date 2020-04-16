package main;

import components.ViewManager;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

  @Override
  public void start(Stage primaryStage) {
    ViewManager viewManager = new ViewManager();
    primaryStage = viewManager.getStage();
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
}
