package components.buttons;

import components.subscenes.pregamemenupanes.HelpWindow;

public class HelpButton extends DefaultButton {
  public HelpButton() {
    super("Help");

    setOnMouseClicked(
        e -> {
          HelpWindow help = new HelpWindow("Help");
          help.showAndWait();
        });
  }
}
