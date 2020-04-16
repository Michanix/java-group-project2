package components.buttons;

import javafx.scene.control.Button;
import javafx.scene.effect.DropShadow;

public class StartMenuButton extends Button {
  // private final String style = ;

  public StartMenuButton(String str) {
    super(str);
    setStartButtonStyle();
    initListeners();
  }

  private void setStartButtonStyle() {
    setPrefWidth(200);
    setStyle("-fx-background-color: lightblue; -fx-font-size: 16pt");
  }

  private void initListeners() {

    setOnMouseEntered(e ->{
      setEffect(new DropShadow());
    });

    setOnMouseExited(e -> {
      setEffect(null);
    });
  }

}
