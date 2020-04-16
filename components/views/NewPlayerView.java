package components.views;

// TODO: split logic by view, controller and model...someday
// TODO: data validation
// TODO: fix alert
import components.buttons.DefaultButton;
import entities.player.ArmorType;
import entities.player.Player;
import entities.player.RaceType;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import utils.WriteToFile;

public class NewPlayerView implements View {
  // what player see
  private final GridPane view = new GridPane();
  // Texts
  private final Text armorDisc = new Text();
  private final Text raceDisc = new Text();
  private final TextFlow displayArmorText = new TextFlow(armorDisc);
  private final TextFlow displayRaceText = new TextFlow(raceDisc);
  // Choices
  private final ChoiceBox<ArmorType> armorChoice = new ChoiceBox<>();
  private final ChoiceBox<RaceType> raceChoice = new ChoiceBox<>();
  // Textfields
  private final TextField nicknameField = new TextField();
  // Labels
  private final Label nicknameLabel = new Label("Nickname: ");
  private final Tooltip nicknameTT = new Tooltip("No longer than 12 characters");
  private final Label armorLabel = new Label("Choose armor: ");
  private final Label raceLabel = new Label("Choose race: ");
  private final Label weaponLabel = new Label("Choose weapon:\n Bare Hands");
  private final Tooltip weaponTT = new Tooltip("New players start without actual weapon");
  // Buttons
  private final DefaultButton createBtn = new DefaultButton("Create and continue");
  // creating arrays of enum types for later usage
  private final RaceType[] raceTypes = RaceType.values();
  private final ArmorType[] armorTypes = ArmorType.values();

  public NewPlayerView() {
    init();
  }

  public GridPane getView() {
    return view;
  }

  public void init() {
    int width = 130;

    armorChoice.getItems().addAll(armorTypes);
    raceChoice.getItems().addAll(raceTypes);
    armorChoice.setPrefWidth(width);
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
    armorChoice
        .getSelectionModel()
        .selectedIndexProperty()
        .addListener(
            (observable, oldValue, newValue) -> {
              armorDisc.setText(String.valueOf(armorTypes[newValue.intValue()].getDescription()));
            });
    // Creating and saving new Player to a file
    createBtn.setOnMouseClicked(
        e -> {
          try {
            WriteToFile.writePlayerToFile(
                Player.createNewPlayer(
                    nicknameField.getText(), raceChoice.getValue(), armorChoice.getValue()));
          } catch (IllegalArgumentException ex) {
            System.err.println(ex.getMessage());
            Alert alert = new Alert(Alert.AlertType.ERROR, ex.getMessage(), ButtonType.OK);
            alert.showAndWait()
                    .filter(res -> res == ButtonType.OK)
                    .ifPresent(res -> alert.hide());
          }
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
    view.add(armorChoice, 1, 7);
    view.add(displayArmorText, 2, 7);
    // weapon
    view.add(weaponLabel, 1, 8);
    weaponLabel.setTooltip(weaponTT);

    view.add(createBtn, 2, 9);
    view.setVgap(5);
    view.setHgap(100);
  }
}
