package components.buttons;

public class ExitButton extends DefaultButton {
    public ExitButton() {
        super("Exit");
        setOnMouseClicked(e -> {
            System.exit(0);
        });
    }
}
