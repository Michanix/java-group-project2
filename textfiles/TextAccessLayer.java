package textfiles;

// TODO: less complexity....
// TODO: refactoring, separate concerns, maybe more abstraction
import javafx.scene.text.Text;
import utils.ReadFromFile;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// TODO: generic access to adventures text as there can be more than one adventure...

public class TextAccessLayer {

  private final Map<String, Text> levelTexts;
  private final String pathToTexts;

  public TextAccessLayer(String pathToTexts) {
    this.pathToTexts = pathToTexts;
    this.levelTexts = getLevelTexts();
  }

  private Map<String, Text> getLevelTexts() {
    Map<String, Text> result = new HashMap<>();
    // platform independent path to avoid problems like in the first group project, lol
    File folder = new File(separatorsToSystem(pathToTexts));
    File[] listOfFiles = folder.listFiles();
    StringBuilder str = new StringBuilder();

    if (listOfFiles != null) {
      for (File listOfFile : listOfFiles) {
        // getting content of the file as List
        List<String> textList = ReadFromFile.readTextToList(String.valueOf(listOfFile));
        // String to be used for Text node
        for (String s : textList) {
          str.append(s).append("\n");
        }
        String[] name = listOfFile.getName().split("\\.");
        result.put(name[0], new Text(str.toString()));
        // Instead of creating new StringBuilder each time
        str.setLength(0);
      }
    } else {
      throw new NullPointerException();
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
