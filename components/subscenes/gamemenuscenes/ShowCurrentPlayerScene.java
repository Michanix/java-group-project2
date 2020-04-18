package components.subscenes.gamemenuscenes;

import components.buttons.DefaultButton;
import entities.player.Player;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class ShowCurrentPlayerScene extends AbstractSubScene {
  private DefaultButton continueBtn;
  private DefaultButton backBtn;
  private AnchorPane subScene;

  public ShowCurrentPlayerScene(Pane root, Player player) {
    super(root);
    subScene = (AnchorPane) this.getRoot();
    VBox stats = new VBox();
    stats.getChildren().add(new Text(player.getNickname()));
    stats.getChildren().add(new Text(String.valueOf(player.getExp())));
    stats.getChildren().add(new Text(player.getRaceType().toString()));
    stats.getChildren().add(new Text(player.getArmorType().toString()));
    stats.getChildren().add(new Text(player.getWeaponType().toString()));
    stats.getChildren().add(new Text(player.getAbilities().toString()));
    stats.setSpacing(5);
    subScene.getChildren().add(stats);
  }
}
