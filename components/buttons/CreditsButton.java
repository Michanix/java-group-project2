package components.buttons;

import components.modals.CreditsModal;

public class CreditsButton extends DefaultButton {
  public CreditsButton() {
    super("Credits");
    setOnMouseClicked(
        e -> {
          CreditsModal credits = new CreditsModal();
          credits.showAndWait();
        });
  }
}
