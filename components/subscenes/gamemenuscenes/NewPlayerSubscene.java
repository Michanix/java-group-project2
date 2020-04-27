package components.subscenes.gamemenuscenes;

import components.buttons.DefaultButton;
import entities.player.ArmorType;
import entities.player.Player;
import entities.player.RaceType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;
import javafx.scene.text.TextFlow;
import utils.WriteToFile;

public class NewPlayerSubscene extends AbstractSubScene {
  private Player newPlayer;
  // Texts
  private final Text armorDisc = new Text();
  private final Text raceDisc = new Text();
  private final TextFlow displayArmorText = new TextFlow(armorDisc);
  private final TextFlow displayRaceText = new TextFlow(raceDisc);
  private final Text err = new Text();
  // Choices
  private final ChoiceBox<RaceType> raceChoice = new ChoiceBox<>();
  // Textfields
  private final TextField nicknameField = new TextField();
  // Labels
  private final Label nicknameLabel = new Label("Nickname: ");
  private final Tooltip nicknameTT = new Tooltip("No longer than 12 characters");
  private final Label armorLabel = new Label("Choose armor:\nClothes");
  private final Tooltip armorTT = new Tooltip("New player start in regular clothes");
  private final Label raceLabel = new Label("Choose race: ");
  private final Label weaponLabel = new Label("Choose weapon:\n Bare Hands");
  private final Tooltip weaponTT = new Tooltip("New players start without actual weapon");
  // Buttons
  private final DefaultButton createBtn = new DefaultButton("Create");
  private final DefaultButton continueBtn = new DefaultButton("Continue");
  // creating arrays of enum types for later usage
  private final RaceType[] raceTypes = RaceType.values();
  private final AnchorPane subScene;

  public NewPlayerSubscene(Pane root) {
    super(root);
    subScene = (AnchorPane) this.getRoot();
    subScene.getChildren().add(createView());
  }

  private GridPane createView() {
    GridPane view = new GridPane();
    int width = 130;

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
          try {
            newPlayer =
                Player.createNewPlayer(
                    nicknameField.getText(), raceChoice.getValue(), ArmorType.CLOTHES);
            WriteToFile.writePlayerToFile(newPlayer);
            Text success = new Text("Character has been created!");
            success.setFill(Color.GREEN);
            view.add(continueBtn, 2, 10);
            view.add(success, 2, 3);
            view.getChildren().remove(createBtn);
          } catch (IllegalArgumentException | NullPointerException ex) {
            err.setText(ex.getMessage());
            err.setFill(Color.RED);
            view.add(err, 2, 3);
          }
        });

    createBtn.setOnMouseReleased(e -> {
      view.getChildren().remove(err);
    });

    continueBtn.setOnMouseClicked(
            e -> {
              System.out.println(newPlayer);
              ShowCurrentPlayerScene showPlayer = new ShowCurrentPlayerScene(subScene, newPlayer);
              subScene.getChildren().add(showPlayer);
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
