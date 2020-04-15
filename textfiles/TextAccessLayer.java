package textfiles;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

public class TextAccessLayer implements TextDAO {

  public static void main(String[] args) {
    Map<String, Path> test = fetchAllTexts();
    for (Map.Entry<String, Path> pair : test.entrySet()) {
      System.out.println("Name= " + pair.getKey() + " Path= " + pair.getValue());
    }
  }

  private Map<String, Path> levelTexts = new HashMap<>();

  public TextAccessLayer() {}

  private static Map<String, Path> fetchAllTexts() {
    Map<String, Path> result = new HashMap<>();
    // platform independent path to avoid problems like in first group project, lol
    String path =
        "src"
            + File.separator
            + "textfiles"
            + File.separator
            + "firstlevel"
            + File.separator
            + "texts";
    File folder = new File(path);
    File[] listOfFiles = folder.listFiles();
    if (listOfFiles != null) {
      for (File listOfFile : listOfFiles) {
        if (listOfFile.isFile()) {
          try {
            String[] name = listOfFile.getName().split("\\.");
            result.put(name[0], Path.of(separatorsToSystem(listOfFile.getCanonicalPath())));
          } catch (IOException ex) {
            ex.printStackTrace();
          }
        }
      }
    } else {
      System.out.println("yikes");
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
    return null;
  }

  @Override
  public String getText(String textName) {
    return null;
  }
}
