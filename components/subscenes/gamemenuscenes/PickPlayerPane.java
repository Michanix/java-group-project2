package components.subscenes.gamemenuscenes;

import components.buttons.DefaultButton;
import entities.player.Player;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import utils.ReadFromFile;

import java.util.List;

public class PickPlayerPane extends AbstractPreGamePane {

  public PickPlayerPane() {
    List<String> nicknames = ReadFromFile.readNicknames();
    ListView<String> listView = new ListView<>();
    Label label = new Label("Available players");
    DefaultButton pickBtn = new DefaultButton("Load");
    VBox menu = new VBox(label, listView, pickBtn);

    loadPlayerController(pickBtn, listView);

    listView.getItems().addAll(nicknames);
    listView.setPrefSize(200, 200);
    menu.setLayoutX(185);
    menu.setLayoutY(110);
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
