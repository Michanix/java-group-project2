package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFromFile {
  public List<String> readFileToList(String path) throws Exception {
    // Takes in text file with some data and returns it as ArrayList<>()
    // Assumed that data on seperate line
    BufferedReader in = null;
    List<String> listOFText = new ArrayList<>();
    try {
      in = new BufferedReader(new FileReader(path));
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (in != null) {
        in.close();
      }
    }
    return listOFText;
  }
}
