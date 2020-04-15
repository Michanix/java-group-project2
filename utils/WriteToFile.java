package utils;

import entities.player.Player;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

// TODO: make path compatible with others platforms
// TODO: Substitute PrintWriter with BufferedWriter for performance(according to internet).

public class WriteToFile {
  public static void writePlayerToFile(Player player) {
    try (PrintWriter output = new PrintWriter(new FileWriter("players/players.txt", true))) {
      output.println(player.toString());
      System.out.println("Player " + player.getNickname() + " was created.");
    } catch (FileNotFoundException e) {
      System.err.println("File not found." + e);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
