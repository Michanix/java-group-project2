package components;

import components.views.StartGameMenuView;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class ViewManager {

    private final int WIDTH = 800;
    private final int HEIGHT = 480;
    private AnchorPane anchorPane;
    private Stage stage;
    private Scene scene;

    public ViewManager() {
        anchorPane = new AnchorPane();
        scene = new Scene(anchorPane, WIDTH, HEIGHT);
        stage = new Stage();
        setStarGameMenu();
        stage.setScene(scene);
    }

    public Stage getStage() {
        return stage;
    }

    private void setStarGameMenu() {
        StartGameMenuView startGameMenuView = new StartGameMenuView(anchorPane, scene);
        startGameMenuView.getMenu().setLayoutX(scene.getWidth()/2 - 100);
        startGameMenuView.getMenu().setLayoutY(scene.getHeight()/2 - 50);
        anchorPane.getChildren().add(startGameMenuView.getMenu());
    }
}
