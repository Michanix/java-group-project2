package utils;

import entities.player.Player;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class WriteToFile {
  public static void writePlayerToFile(Player player) {
    try (Writer output =
        new BufferedWriter(
            new OutputStreamWriter(
                new FileOutputStream("players/players.txt", true), StandardCharsets.UTF_8))) {
      output.append(player.toString()).append("\r\n");
      System.out.println("Player " + player.getNickname() + " was created.");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
