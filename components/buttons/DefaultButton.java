package components.buttons;

import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;

public class DefaultButton extends Button {
  // private final String style = ;

    public DefaultButton() {
    }

    public DefaultButton(String str) {
    super(str);
    setStartButtonStyle();
    initListeners();
  }

  private void setStartButtonStyle() {
    setPrefWidth(200);
    setStyle("-fx-background-color: lightblue; -fx-font-size: 16pt");
    setWrapText(true);
  }

  private void initListeners() {
    DropShadow shadow = new DropShadow();
    setOnMouseEntered(
        e -> {
          setEffect(shadow);
        });

    setOnMouseExited(
        e -> {
          setEffect(null);
        });
  }
}
