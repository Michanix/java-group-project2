package entities;

import utils.ReadFromFile;
import utils.WriteToFile;

import java.util.List;

public class Test {
  public static void main(String[] args) {
    Player player1 =
        Player.createNewPlayer(
                "michanix", 0,
                RaceType.DWARF, WeaponType.AXE, ArmorType.HEAVYARMOR);

    Player player2 = Player.createNewPlayer(
            "notMichanix", 0,
            RaceType.ELF, WeaponType.BAREHANDS, ArmorType.GARMENT
    );
    Player player3 = Player.createNewPlayer(
            "micha2", 0,
            RaceType.ELF, WeaponType.BAREHANDS, ArmorType.GARMENT
    );

    Player player4;

    WriteToFile writeToFile = new WriteToFile();
    ReadFromFile readFromFile = new ReadFromFile();
    List<String> playerParams = readFromFile.readPlayerParamsFromFile("michanix");

    player4 = Player.loadExistingPlayer(
            playerParams.get(0),
            Integer.parseInt(playerParams.get(1)),
            RaceType.valueOf(playerParams.get(4).toUpperCase()),
            new Abilities(
                    Integer.parseInt(playerParams.get(5)),
                    Integer.parseInt(playerParams.get(6)),
                    Integer.parseInt(playerParams.get(7)),
                    Integer.parseInt(playerParams.get(8)),
                    Integer.parseInt(playerParams.get(9)),
                    Integer.parseInt(playerParams.get(10))
            ),
            WeaponType.valueOf(playerParams.get(11).toUpperCase()),
            ArmorType.valueOf("HEAVYARMOR")
    );

    System.out.println(player1);
    System.out.println(player4);
  }
}
