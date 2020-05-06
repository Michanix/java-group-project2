package utils;

import entities.player.Player;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class WriteToFile {
  private static final String DESTINATION_FILE = "players.txt";
  private static final Charset ENCODING = StandardCharsets.UTF_8;

  public static void writePlayerToFile(Player player) {
    try {
      Files.writeString(
          Path.of(DESTINATION_FILE), player.toString() + "\n", ENCODING, StandardOpenOption.APPEND);
      System.out.println("Player " + player.getNickname() + " was created.");
    } catch (IOException ex) {
      ex.printStackTrace();
    }
  }
}
