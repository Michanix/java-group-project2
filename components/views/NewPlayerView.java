package components.views;


// in progress...
import entities.player.ArmorType;
import entities.player.RaceType;
import javafx.geometry.Pos;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class NewPlayerView {

    public Pane init() {
        Pane borderPane = new Pane();
        VBox leftVBox = new VBox();
        VBox rightVBox = new VBox();
        Text text = new Text("al othafdadngasdfasdfanjad;lfadskfm" +
                "adfasdfasdf");

        ChoiceBox<ArmorType> choiceBox1 = new ChoiceBox<>();
        ChoiceBox<RaceType> choiceBox2 = new ChoiceBox<>();

        choiceBox1.getItems().addAll(ArmorType.values());
        choiceBox2.getItems().addAll(RaceType.values());

        leftVBox.getChildren().addAll(choiceBox1, choiceBox2);
        leftVBox.setAlignment(Pos.CENTER_LEFT);
        rightVBox.getChildren().add(text);
        rightVBox.setAlignment(Pos.CENTER_RIGHT);

        borderPane.getChildren().addAll(leftVBox, rightVBox);
        return borderPane;
    }
}
