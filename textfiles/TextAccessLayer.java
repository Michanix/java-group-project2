package textfiles;

import javafx.scene.text.Text;
import utils.ReadFromFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TextAccessLayer implements TextDAO {

  private final Map<String, Text> levelTexts;

  public TextAccessLayer() {
    this.levelTexts = getLevelTexts();
  }

  private Map<String, Text> getLevelTexts() {
    /*
    Function to return Map of texts as <Name of the text, Javafx Text node>
     */
    Map<String, Text> result = new HashMap<>();
    List<Path> pathsToTexts = fetchTextsPaths();

    // Iterating through list of paths
    // and from each path grabbing text and creating StringBuilder Object which is later used
    // to create JavaFx Text node
    for (Path path : pathsToTexts) {
      List<String> textList = ReadFromFile.readTextToList(String.valueOf(path));
      StringBuilder str = new StringBuilder();
      for (String s : textList) {
        str.append(s).append("\n");
      }
      String[] name = path.getFileName().toString().split("\\.");
      result.put(name[0], new Text(String.valueOf(str)));
    }
    return result;
  }

  private List<Path> fetchTextsPaths() {
    /*
    Helper function to fetch all the txt file from directory
    as create list of their paths
     */
    List<Path> result = new ArrayList<>();
    // platform independent path to avoid problems like in the first group project, lol
    File folder = new File(separatorsToSystem("src/textfiles/firstlevel/texts"));
    File[] listOfFiles = folder.listFiles();
    if (listOfFiles != null) {
      for (File listOfFile : listOfFiles) {
        try {
          result.add(Path.of(separatorsToSystem(listOfFile.getCanonicalPath())));
        } catch (IOException ex) {
          ex.printStackTrace();
        }
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
