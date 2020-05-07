package components.subscenes.pregamemenupanes;

import components.buttons.DefaultButton;
import entities.player.ArmorType;
import entities.player.Player;
import entities.player.RaceType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import utils.ReadFromFile;
import utils.WriteToFile;

public class NewPlayerPane extends AbstractPreGamePane {
  // Texts
  private final Text     armorDisc        = new Text();
  private final Text     raceDisc         = new Text();
  private final TextFlow displayArmorText = new TextFlow(armorDisc);
  private final TextFlow displayRaceText  = new TextFlow(raceDisc);
  private final Text     msg              = new Text();
  // Choices
  private final ChoiceBox<RaceType> raceChoice = new ChoiceBox<>();
  // Textfields
  private final TextField nicknameField = new TextField();
  // Labels
  private final Label nicknameLabel = new Label("Nickname: ");
  private final Tooltip nicknameTT  = new Tooltip("No longer than 12 characters");
  private final Label armorLabel    = new Label("Choose armor:\nClothes");
  private final Tooltip armorTT     = new Tooltip("New player start in regular clothes");
  private final Label raceLabel     = new Label("Choose race: ");
  private final Label weaponLabel   = new Label("Choose weapon:\n Bare Hands");
  private final Tooltip weaponTT    = new Tooltip("New players start without actual weapon");
  // Buttons
  private final DefaultButton createBtn   = new DefaultButton("Create");
  private final DefaultButton continueBtn = new DefaultButton("Continue");
  // creating arrays of enum types for later usage
  private final RaceType[] raceTypes = RaceType.values();
  private Player newPlayer;

  public NewPlayerPane() {
    getChildren().add(createView());
  }

  private GridPane createView() {
    GridPane view = new GridPane();
    int width = 130;

    // Default color of the message
    msg.setFill(Color.RED);

    raceChoice.getItems().addAll(raceTypes);
    raceChoice.setPrefWidth(width);
    nicknameField.setPrefWidth(width);

    // Displaying brief description of each race/armor when selected
    raceChoice
        .getSelectionModel()
        .selectedIndexProperty()
        .addListener(
            (observable, oldValue, newValue) -> {
              raceDisc.setText(String.valueOf(raceTypes[newValue.intValue()].getDescription()));
            });
    // Creating and saving new Player to a file
    createBtn.setOnMouseClicked(
        e -> {
          // Should List of nicknames be cached?
          if (!(ReadFromFile.playerExist(nicknameField.getText()))) {
            try {
              newPlayer =
                      Player.createNewPlayer(
                              nicknameField.getText(), raceChoice.getValue(), ArmorType.CLOTHES);
              msg.setText("Character has been created!");
              msg.setFill(Color.GREEN);
              view.add(continueBtn, 2, 10);
              view.getChildren().remove(createBtn);
            } catch (IllegalArgumentException | NullPointerException ex) {
              msg.setText(ex.getMessage());
            }
          } else {
            msg.setText("Name already taken.");
          }
          view.add(msg, 2, 3);
        });

    createBtn.setOnMouseReleased(
        e -> {
          view.getChildren().remove(msg);
        });

    continueBtn.setOnMouseClicked(
        e -> {
          ShowNewPlayerPane showPlayer = new ShowNewPlayerPane(newPlayer);
          getScene().setRoot(showPlayer);
        });
    // setup
    // name
    nicknameField.setTooltip(nicknameTT);
    view.add(nicknameLabel, 1, 2);
    view.add(nicknameField, 1, 3);
    // race
    displayRaceText.setTextAlignment(TextAlignment.LEFT);
    view.add(raceLabel, 1, 4);
    view.add(raceChoice, 1, 5);
    view.add(displayRaceText, 2, 5);
    // armor
    displayArmorText.setTextAlignment(TextAlignment.LEFT);
    view.add(armorLabel, 1, 6);
    armorLabel.setTooltip(armorTT);
    // weapon
    view.add(weaponLabel, 1, 8);
    weaponLabel.setTooltip(weaponTT);

    view.add(createBtn, 2, 9);
    view.setVgap(5);
    view.setHgap(100);

    return view;
  }
}
