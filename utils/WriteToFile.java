package utils;

import entities.player.Player;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

/*
Use of Files util is justified when dealing with small files.
 */

public class WriteToFile {
  private static final Path DESTINATION_FILE = Path.of("players.txt");
  private static final Charset ENCODING = StandardCharsets.UTF_8;

  public static void check() {
    try {
      Files.createFile(DESTINATION_FILE);
      System.out.println("Database 'players.txt' has been created.");
    } catch (IOException ex) {
      System.out.println("Database status: OK");
    }
  }

  public static void writePlayerToFile(Player player) {
    List<String> nicknames = ReadFromFile.readNicknames();
    if (!(nicknames.contains(player.getNickname()))) {
      appendPlayerToFile(player);
    } else {
      findAndUpdate(player);
    }
  }

  private static void appendPlayerToFile(Player player) {
    try {
      Files.writeString(
          DESTINATION_FILE, player.toString() + "\n", ENCODING, StandardOpenOption.APPEND);
      System.out.println("Player " + player.getNickname() + " was saved.");
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }

  private static void findAndUpdate(Player player) {
    try {
      // Getting all players from file int List
      List<String> listOfPlayer = Files.readAllLines(DESTINATION_FILE, ENCODING);
      // Updating players by unique id
      listOfPlayer.forEach(
          p -> {
            if (p.contains(player.getId().toString())) {
              listOfPlayer.set(listOfPlayer.indexOf(p), player.toString());
              System.out.println("Player entry has been updated.");
            }
          });
      // Writing back updated List
      Files.write(DESTINATION_FILE, listOfPlayer, ENCODING);
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }

  public static void findAndDelete(String nickname) {
    try {
      List<String> listOfPlayer = Files.readAllLines(DESTINATION_FILE, ENCODING);
      listOfPlayer.removeIf(p -> p.contains(nickname));
      System.out.println(nickname + " has been deleted.");
      Files.write(DESTINATION_FILE, listOfPlayer, ENCODING);
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }
}
