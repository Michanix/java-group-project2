package utils;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReadFromFile {
  public List<String> readTextToList(String path) {
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

  // Loading player from file based on nickname
  public List<String> readPlayerParamsFromFile(String nickname) {
    String path = "players/players.txt";
    List<String> playerParams = new ArrayList<>();
    try (BufferedReader input = new BufferedReader(new FileReader(path))) {
      String line;
      while ((line = input.readLine()) != null) {
        if (line.contains(nickname)) {
          // Some expensive Regex hacks to parse Player back to object
          // ~2ms to parse a line so its okay
          String[] tmp = line.split(",");
          Pattern rgx = Pattern.compile("(?>=(\\w*.\\w*))");
          for (String t : tmp) {
            Matcher matcher = rgx.matcher(t);
            if (matcher.find()) {
              playerParams.add(matcher.group(1));
            }
          }
        }
      }
    } catch (FileNotFoundException er) {
      System.err.println("File not found. " + er);
    } catch (IOException er) {
      er.printStackTrace();
    }
    return playerParams;
  }
}
