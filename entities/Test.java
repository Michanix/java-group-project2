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
      Player p1 = Player.createNewPlayer("miha2", RaceType.BARBARIAN, ArmorType.HEAVYARMOR);
      Player p2 = ReadFromFile.loadPlayerFromFile("miha2");
      System.out.println(p2);
  }
}
