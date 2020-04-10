package utils;

import entities.Player;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class WriteToFile {
  public void writePlayerToFile(Player player) {
    try (PrintWriter output = new PrintWriter(new FileWriter("players/players.txt", true))) {
      output.println(player.toString());

    } catch (FileNotFoundException e) {
      System.err.println("File not found." + e);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
