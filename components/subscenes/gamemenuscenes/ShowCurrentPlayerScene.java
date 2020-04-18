package components.subscenes.gamemenuscenes;

import components.buttons.DefaultButton;
import entities.player.Player;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.util.ArrayList;
import java.util.List;

public class ShowCurrentPlayerScene extends AbstractSubScene {
  private DefaultButton continueBtn;
  private AnchorPane subScene;

  public ShowCurrentPlayerScene(Pane root, Player player) {
    super(root);
    List<TitledPane> titledPaneList =
        new ArrayList<>(
            List.of(
                new TitledPane("Nickname", new Label(player.getNickname())),
                new TitledPane("Experience", new Label(String.valueOf(player.getExp()))),
                new TitledPane("Race", new Label(player.getRaceType().toString())),
                new TitledPane("Armor", new Label(player.getArmorType().toString())),
                new TitledPane("Weapon", new Label(player.getWeaponType().toString())),
                new TitledPane("Abilities", new Label(player.getAbilities().toString()))));
    for (TitledPane pane : titledPaneList) {
      pane.setExpanded(true);
    }
    subScene = (AnchorPane) this.getRoot();
    VBox stats = new VBox();
    continueBtn = new DefaultButton("Continue");

    continueBtn.setOnMouseClicked(
        e -> {
          AdventureMenuSubScene adventureMenu = new AdventureMenuSubScene(subScene);
          subScene.getChildren().add(adventureMenu);
        });

    stats.getChildren().addAll(titledPaneList);
    stats.getChildren().add(continueBtn);
    stats.setLayoutX(195);
    stats.setLayoutY(40);
    subScene.getChildren().add(stats);
  }
}
