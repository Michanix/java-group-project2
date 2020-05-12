package components.subscenes.pregamemenupanes;

import components.buttons.DefaultButton;
import components.buttons.MainMenuButton;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

public class ManagePlayersPane extends AbstractPreGamePane {

  public ManagePlayersPane() {
    HBox firstRow  = new HBox();
    HBox secondRow = new HBox();
    DefaultButton newPlayerBtn    = new DefaultButton("Create new player");
    DefaultButton existingPlBtn   = new DefaultButton("Pick existing player");
    MainMenuButton mainMenuButton = new MainMenuButton();

    VBox menu = new VBox(firstRow, secondRow);
    createNewPlayer(newPlayerBtn);
    chooseExistPlayer(existingPlBtn);

    firstRow.getChildren().addAll(newPlayerBtn, existingPlBtn);
    firstRow.setSpacing(10);
    secondRow.getChildren().add(mainMenuButton);

    menu.setLayoutX(195);
    menu.setLayoutY(90);
    menu.setSpacing(10);
    getChildren().add(menu);
  }

  private void createNewPlayer(Button button) {
    button.setOnMouseClicked(
        e -> {
          NewPlayerPane newPlayerView = new NewPlayerPane();
          getScene().setRoot(newPlayerView);
        });
  }

  private void chooseExistPlayer(Button button) {
    button.setOnMouseClicked(
        e -> {
          PickPlayerPane pickPlayerPane = new PickPlayerPane();
          getScene().setRoot(pickPlayerPane);
        });
  }
}
