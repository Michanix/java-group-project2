package components.buttons;

import components.modals.HelpModal;

public class HelpButton extends DefaultButton {
  public HelpButton() {
    super("Help");
    setOnMouseClicked(
        e -> {
          HelpModal help = new HelpModal();
          help.showAndWait();
        });
  }
}
