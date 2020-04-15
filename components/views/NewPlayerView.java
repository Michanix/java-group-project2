package components.views;

import entities.player.ArmorType;
import entities.player.Player;
import entities.player.RaceType;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import utils.WriteToFile;

public class NewPlayerView {
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
  private final Label armorLabel = new Label("Choose armor: ");
  private final Label raceLabel = new Label("Choose race: ");
  private final Label weaponLabel = new Label("Choose weapon:\n Bare Hands");
  private final Tooltip weaponTT = new Tooltip("New players start without actual weapon");
  // Buttons
  private final Button createBtn = new Button("Create and continue");
  // creating arrays of enum types for later usage
  private final RaceType[] raceTypes = RaceType.values();
  private final ArmorType[] armorTypes = ArmorType.values();
  private final WriteToFile writeToFile = new WriteToFile();

  public NewPlayerView() {}

  public Pane init() {
    int width = 130;

    armorChoice.getItems().addAll(ArmorType.values());
    raceChoice.getItems().addAll(RaceType.values());
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
          writeToFile.writePlayerToFile(
              Player.createNewPlayer(
                  nicknameField.getText(), raceChoice.getValue(), armorChoice.getValue()));
        });

    // setup
    view.setAlignment(Pos.CENTER);
    // name
    view.add(nicknameLabel, 0, 0);
    view.add(nicknameField, 0, 1);
    // race
    displayRaceText.setTextAlignment(TextAlignment.LEFT);
    view.add(raceLabel, 0, 2);
    view.add(raceChoice, 0, 3);
    view.add(displayRaceText, 1, 3);
    // armor
    displayArmorText.setTextAlignment(TextAlignment.LEFT);
    view.add(armorLabel, 0, 4);
    view.add(armorChoice, 0, 5);
    view.add(displayArmorText, 1, 5);
    // weapon
    view.add(weaponLabel, 0, 6);
    weaponLabel.setTooltip(weaponTT);

    view.add(createBtn, 1, 7);
    view.setVgap(20);
    view.setHgap(20);
    return view;
  }
}
