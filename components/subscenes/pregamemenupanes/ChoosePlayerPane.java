package components.subscenes.pregamemenupanes;

import components.buttons.DefaultButton;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class ChoosePlayerPane extends AbstractPreGamePane {

  public ChoosePlayerPane() {
    HBox menu = new HBox();
    DefaultButton newPlayerBtn = new DefaultButton("Create new player");
    DefaultButton existingPlBtn = new DefaultButton("Pick existing player");

    createNewPlayer(newPlayerBtn);
    chooseExistPlayer(existingPlBtn);

    menu.getChildren().addAll(newPlayerBtn, existingPlBtn);

    menu.setLayoutX(195);
    menu.setLayoutY(110);
    menu.setSpacing(5);

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
