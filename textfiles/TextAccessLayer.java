package textfiles;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class TextAccessLayer implements TextDAO {

  private Map<String, Path> levelTexts;

  public TextAccessLayer() {
    this.levelTexts = fetchAllTexts("src/textfiles/firstlevel/texts");
  }

  private static Map<String, Path> fetchAllTexts(String path) {
    Map<String, Path> result = new HashMap<>();
    // platform independent path to avoid problems like in the first group project, lol
    File folder = new File(separatorsToSystem(path));
    File[] listOfFiles = folder.listFiles();
    if (listOfFiles != null) {
      for (File listOfFile : listOfFiles) {
        try {
          String[] name = listOfFile.getName().split("\\.");
          result.put(name[0], Path.of(separatorsToSystem(listOfFile.getCanonicalPath())));
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
  public Map<String, Path> getAllTexts() {
    return levelTexts;
  }

  @Override
  public Path getText(String textName) {
    return levelTexts.get(textName);
  }
}
