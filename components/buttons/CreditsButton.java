package components.buttons;

import components.modals.CreditsWindow;

public class CreditsButton extends DefaultButton {
  public CreditsButton() {
    super("Credits");
    setOnMouseClicked(
        e -> {
          CreditsWindow credits = new CreditsWindow();
          credits.showAndWait();
        });
  }
}
