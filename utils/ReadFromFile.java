package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFromFile {
  public List<String> readFileToList(String path) {
    // Takes in text file with some data and returns it as ArrayList<>()
    // Assumed that data on seperate line
    List<String> listOFText = new ArrayList<>();
    try (BufferedReader input = new BufferedReader(new FileReader(path))) {
      String line;
      while ((line = input.readLine()) != null) {
        listOFText.add(line);
      }
    } catch (FileNotFoundException er) {
      System.err.println("File not found. " + er);
    } catch (IOException er) {
      er.printStackTrace();
    }
    return listOFText;
  }
}
