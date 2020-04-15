package components.views;

// in progress...

import entities.player.ArmorType;
import entities.player.RaceType;
import javafx.geometry.Pos;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

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
  private final Tooltip weapontTT = new Tooltip("New players start without actual weapon");

  public NewPlayerView() {
  }

  public Pane init() {
    RaceType[] raceTypes = RaceType.values();
    ArmorType[] armorTypes = ArmorType.values();

    armorChoice.getItems().addAll(ArmorType.values());
    raceChoice.getItems().addAll(RaceType.values());
    armorChoice.setPrefWidth(130);
    raceChoice.setPrefWidth(130);
    nicknameField.setPrefWidth(130);

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


    weaponLabel.setTooltip(weapontTT);
    // setup
    view.setAlignment(Pos.CENTER);
    // name
    view.add(nicknameLabel, 0, 0);
    view.add(nicknameField, 0, 1);
    // race
    view.add(raceLabel, 0, 2);
    view.add(raceChoice, 0, 3);
    view.add(displayRaceText, 1, 3);
    // armor
    view.add(armorLabel, 0, 4);
    view.add(armorChoice, 0, 5);
    view.add(displayArmorText, 1, 5);
    view.add(weaponLabel, 0, 6);
    view.setVgap(20);
    view.setHgap(20);
    return view;
  }
}
