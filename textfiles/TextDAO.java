package textfiles;

// Making use of Data Access Object pattern, sort of...

import javafx.scene.text.Text;

import java.util.Map;

public interface TextDAO {
  Map<String, Text> getAllTexts();

  Text getText(String textName);
}
