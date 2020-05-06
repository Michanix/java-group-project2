package entities;

import entities.player.ArmorType;
import entities.player.Player;
import entities.player.RaceType;
import entities.player.WeaponType;
import utils.ReadFromFile;
import utils.WriteToFile;

import java.util.List;

public class Test {
  public static void main(String[] args) {
      Player player = ReadFromFile.loadPlayerFromFile("mihhail");
      Player player1 = Player.createNewPlayer("misha", RaceType.BARBARIAN, ArmorType.HEAVYARMOR);
      WriteToFile.writePlayerToFile(player1);
  }
}
