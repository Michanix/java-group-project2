package components.subscenes.pregamemenupanes;

import components.buttons.DefaultButton;
import components.buttons.MainMenuButton;
import entities.player.Player;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import utils.ReadFromFile;

import java.util.List;

public class PickPlayerPane extends AbstractPreGamePane {

  public PickPlayerPane() {
    List<String> nicknames    = ReadFromFile.readNicknames();
    ListView<String> listView = new ListView<>();
    Label label               = new Label("Available players");
    DefaultButton pickBtn     = new DefaultButton("Load");
    MainMenuButton toMenu     = new MainMenuButton();
    VBox menu                 = new VBox(label, listView, pickBtn, toMenu);

    loadPlayerController(pickBtn, listView);

    listView.getItems().addAll(nicknames);
    listView.setPrefSize(200, 200);
    menu.setLayoutX(295);
    menu.setLayoutY(90);
    menu.setSpacing(5);

    getChildren().add(menu);
  }

  public void loadPlayerController(Button button, ListView<String> listView) {
    button.setOnAction(
        e -> {
          Object selectedValue = listView.getSelectionModel().getSelectedItem();
          Player player = ReadFromFile.loadPlayerFromFile(String.valueOf(selectedValue));
          ShowNewPlayerPane showPlayer = new ShowNewPlayerPane(player);
          getScene().setRoot(showPlayer);
        });
  }
}