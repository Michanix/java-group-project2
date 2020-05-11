package components.buttons;

import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;

public class DefaultButton extends Button {
  // private final String style = ;

  public DefaultButton() {}

  public DefaultButton(String str) {
    super(str);
    setDefaultStyle();
    initListeners();
  }

  private void setDefaultStyle() {
    setPrefWidth(180);
    setStyle("-fx-background-color: lightblue; -fx-font-size: 14pt");
    setWrapText(true);
  }

  private void initListeners() {
    setOnMouseEntered(
        e -> {
          setEffect(new DropShadow());
        });

    setOnMouseExited(
        e -> {
          setEffect(null);
        });
  }
}
