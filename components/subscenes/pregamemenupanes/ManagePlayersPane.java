package components.subscenes.pregamemenupanes;

import components.buttons.DefaultButton;
import components.buttons.MainMenuButton;
import entities.player.Player;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import utils.ReadFromFile;
import utils.WriteToFile;

import java.util.List;
import java.util.Objects;

public class ManagePlayersPane extends AbstractPreGamePane {
  private final Text warnMsg = new Text();
  
  public ManagePlayersPane() {
    List<String> nicknames    = ReadFromFile.readNicknames();
    ListView<String> listView = new ListView<>();
    // Method to check if there is any available players in the list
    // If none, display appropriate message
    check(nicknames);

    Label label = new Label("Available players: ");

    DefaultButton createBtn = new DefaultButton("Create");
    DefaultButton pickBtn   = new DefaultButton("Load");
    DefaultButton deleteBtn = new DefaultButton("Delete");
    MainMenuButton toMenu   = new MainMenuButton();

    VBox btnMenu  = new VBox(createBtn, pickBtn, deleteBtn, toMenu);
    HBox firstRow = new HBox(label, listView, btnMenu);

    HBox mainView = new HBox(firstRow, btnMenu);

    // Controller to create new players
    createNewPlayer(createBtn);
    // Controller to handle selected players from list
    loadPlayerController(pickBtn, listView);
    // Delete player from list
    deletePlayerController(deleteBtn, listView);

    listView.getItems().addAll(nicknames);
    listView.setPrefSize(200, 200);

    // styling
    firstRow.setSpacing(5);
    btnMenu.setSpacing(5);

    mainView.setAlignment(Pos.CENTER);
    mainView.setLayoutX(155);
    mainView.setLayoutY(90);
    mainView.setSpacing(5);

    warnMsg.setFont(Font.font(16));
    warnMsg.setFill(Color.RED); // default color
    warnMsg.setLayoutX(155);
    warnMsg.setLayoutY(70);

    getChildren().addAll(warnMsg, mainView);
  }

  private void check(List<String> nicknames) {
    if (nicknames.isEmpty()) {
      warnMsg.setText("You don't have player yet. Create new one.");
    }
  }

  private void createNewPlayer(Button button) {
    button.setOnMouseClicked(
        e -> {
          NewPlayerPane newPlayerView = new NewPlayerPane();
          getScene().setRoot(newPlayerView);
        });
  }

  private void loadPlayerController(Button button, ListView<String> listView) {
    button.setOnAction(
        e -> {
          try {
            Object selectedValue = listView.getSelectionModel().getSelectedItem();
            Player player = ReadFromFile.loadPlayerFromFile(String.valueOf(selectedValue));
            System.out.println(player.toString());
            ShowNewPlayerPane showPlayer = new ShowNewPlayerPane(player);
            getScene().setRoot(showPlayer);
          } catch (IndexOutOfBoundsException ex) {
            warnMsg.setText("Player is not selected.");
          }
        });
  }

  private void deletePlayerController(Button button, ListView<String> listView) {
    button.setOnAction(e -> {
      try {
        Object selectedValue = Objects.requireNonNull(listView.getSelectionModel().getSelectedItem());
        WriteToFile.findAndDelete(String.valueOf(selectedValue));
        warnMsg.setText(selectedValue + " has been deleted.");
        warnMsg.setFill(Color.GREEN);
      } catch (IndexOutOfBoundsException ex1) {
        ex1.printStackTrace();
      } catch (NullPointerException ex2) {
        warnMsg.setText("Player is not selected.");
      }
    });
  }
}
