package textfiles;

// TODO: less complexity....

import javafx.scene.text.Text;
import utils.ReadFromFile;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TextAccessLayer implements TextDAO {

  private final Map<String, Text> levelTexts;

  public TextAccessLayer() {
    this.levelTexts = getLevelTexts();
  }

  private Map<String, Text> getLevelTexts() {

    Map<String, Text> result = new HashMap<>();
    // platform independent path to avoid problems like in the first group project, lol
    File folder = new File(separatorsToSystem("src/textfiles/firstlevel/texts"));
    File[] listOfFiles = folder.listFiles();
    if (listOfFiles != null) {
      for (File listOfFile : listOfFiles) {
        List<String> textList = ReadFromFile.readTextToList(String.valueOf(listOfFile));
        StringBuilder str = new StringBuilder();
        for (String s : textList) {
          str.append(s).append("\n");
        }
        String[] name = listOfFile.getName().split("\\.");
        result.put(name[0], new Text(String.valueOf(str)));
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

  @Override
  public Map<String, Text> getAllTexts() {
    return levelTexts;
  }

  @Override
  public Text getText(String textName) {
    return levelTexts.get(textName);
  }
}
