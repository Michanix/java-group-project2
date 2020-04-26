package entities;

import entities.player.ArmorType;
import entities.player.Player;
import entities.player.RaceType;
import utils.ReadFromFile;
import utils.WriteToFile;

import java.util.List;

public class Test {
  public static void main(String[] args) {
      Player newPlayer =
              Player.createNewPlayer(
                     "cozy", RaceType.BARBARIAN, ArmorType.HEAVYARMOR);
      WriteToFile.writePlayerToFile(newPlayer);
      Player test = ReadFromFile.loadPlayerFromFile("cozy");
      System.out.println(test);
  }
}
