package components.buttons;

import components.modals.HelpWindow;

public class HelpButton extends DefaultButton {
  public HelpButton() {
    super("Help");

    setOnMouseClicked(
        e -> {
          HelpWindow help = new HelpWindow();
          help.showAndWait();
        });
  }
}
