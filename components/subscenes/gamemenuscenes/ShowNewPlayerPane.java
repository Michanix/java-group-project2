package components.subscenes.gamemenuscenes;

import components.buttons.DefaultButton;
import entities.player.Player;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class ShowNewPlayerScene extends AbstractPreGamePane {

  public ShowNewPlayerScene(Player player) {
    String abilities =
        String.format(
            "wisdom:         %d\n"
                + "strength:       %d\n"
                + "charisma:       %d\n"
                + "dexterity:      %d\n"
                + "constitution:   %d\n"
                + "intelligence:     %d",
            player.getAbilities().getWisdom(),
            player.getAbilities().getStrength(),
            player.getAbilities().getCharisma(),
            player.getAbilities().getDexterity(),
            player.getAbilities().getConstitution(),
            player.getAbilities().getIntelligence());
    List<TitledPane> titledPaneList =
        new ArrayList<>(
            List.of(
                new TitledPane("Nickname", new Label(player.getNickname())),
                new TitledPane("Experience", new Label(String.valueOf(player.getExp()))),
                new TitledPane("Race", new Label(player.getRaceType().toString())),
                new TitledPane("Armor", new Label(player.getArmorType().toString())),
                new TitledPane("Weapon", new Label(player.getWeaponType().toString())),
                new TitledPane("Abilities", new Label(abilities))));
    for (TitledPane pane : titledPaneList) {
      pane.setExpanded(true);
    }
    VBox stats = new VBox();
    DefaultButton continueBtn = new DefaultButton("Continue");

    continueBtn.setOnMouseClicked(
        e -> {
          AdventureMenuPreGamePane adventureMenu = new AdventureMenuPreGamePane(player);
          getScene().setRoot(adventureMenu);
        });

    stats.getChildren().addAll(titledPaneList);
    stats.getChildren().add(continueBtn);
    stats.setLayoutX(195);
    stats.setLayoutY(40);
    getChildren().add(stats);
  }
}
