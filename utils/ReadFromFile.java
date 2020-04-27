package utils;

import entities.player.*;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

// TODO: find a better, less confusing way to parse player back from file

public class ReadFromFile {
  public static List<String> readTextToList(String path) {
    // Takes in text file with some data and returns it as ArrayList<>()
    // Assumed that data on separate line
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
  private static List<String> readPlayerParamsFromFile(String nickname) {
    String path = "players.txt";
    List<String> playerParams = new ArrayList<>();
    try (BufferedReader input = new BufferedReader(new FileReader(path))) {
      String line;
      while ((line = input.readLine()) != null) {
        if (line.contains(nickname)) {
          // Some expensive Regex hacks to parse Player params to List<String>
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

  // The two private methods below help to
  // parse string representation of RaceType, ArmorType and WeaponType
  // from String to Enums
  private static String splitConcatString(String str) {
    String[] s = str.toUpperCase().split(" ");
    return s[0] + s[1];
  }

  private static String formatString(String str) {
    return !str.contains(" ") ? str.toUpperCase() : splitConcatString(str);
  }

  public static Player loadPlayerFromFile(String nickname) {
    List<String> params = readPlayerParamsFromFile(nickname);
    String race = formatString(params.get(4));
    String weapon = formatString(params.get(11));
    String armor = formatString(params.get(12));
    Abilities abilities =
        Abilities.loadExisting(
            Integer.parseInt(params.get(5)),
            Integer.parseInt(params.get(6)),
            Integer.parseInt(params.get(7)),
            Integer.parseInt(params.get(8)),
            Integer.parseInt(params.get(9)),
            Integer.parseInt(params.get(10)));
    Player player =
        Player.loadExistingPlayer(
            params.get(0),
            Integer.parseInt(params.get(1)),
            RaceType.valueOf(race),
            abilities,
            WeaponType.valueOf(weapon),
            ArmorType.valueOf(armor));

    return player;
  }
}
