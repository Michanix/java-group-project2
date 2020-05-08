package textfiles;

// TODO: less complexity....
// TODO: refactoring, separate concerns, maybe more abstraction
import javafx.scene.text.Text;
import utils.ReadFromFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// TODO: generic access to adventures text as there can be more than one adventure...

public class TextAccessLayer {

  private final Map<String, Text> levelTexts;
  private final String pathToTexts = "src/textfiles/firstadventure/texts";

  public TextAccessLayer() {
    this.levelTexts = getLevelTexts();
  }

  private Map<String, Text> getLevelTexts() {
    Map<String, Text> result = new HashMap<>();
    StringBuilder str = new StringBuilder();
    // platform independent path to avoid problems like in the first group project, lol
    try {
      /*
      Some fancy stream chaining to create HashMap of String and Text node
      where String is a name of the file and Text node content is the content of the file.
       */
      Files.list(Path.of(pathToTexts))
          .forEach(
              file -> {
                List<String> textsList = ReadFromFile.readTextToList(file.toString());
                for (String txt : textsList) {
                  str.append(txt).append("\n");
                }
                String[] name = file.getFileName().toString().split("\\.");
                result.put(name[0], new Text(str.toString()));
                // Instead of creating new StringBuilder each time
                str.setLength(0);
              });
    } catch (IOException ex) {
      ex.printStackTrace();
    }
    return result;
  }

  // source: https://stackoverflow.com/a/35652140
  private static String separatorsToSystem(String res) {
    if (res == null) return null;
    if (File.separatorChar == '\\') {
      // From Windows to Linux/Mac
      return res.replace('/', File.separatorChar);
    } else {
      // From Linux/Mac to Windows
      return res.replace('\\', File.separatorChar);
    }
  }

  public Text getText(String textName) {
    return levelTexts.get(textName);
  }
}
