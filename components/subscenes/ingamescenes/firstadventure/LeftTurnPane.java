package components.subscenes.ingamescenes.firstadventure;

import components.buttons.DefaultButton;
import components.buttons.GoBackButton;
import components.modals.ArteFoundModal;
import components.modals.NothingFoundModel;
import entities.player.Player;
import entities.player.WeaponType;
import utils.GetRandomType;

// TODO: if nothing new found, tell about it, lol
public class LeftTurnPane extends AbstracPane {

  public LeftTurnPane(Player player, String textname) {
    super(player, textname);
    DefaultButton openBtn   = new DefaultButton("Yes, open it");
    GoBackButton backButton = new GoBackButton();

    openBtn.setOnMouseClicked(
        e -> {
          WeaponType rndWeapon = GetRandomType.randomEnum(WeaponType.class);

          if (!(rndWeapon.equals(WeaponType.BAREHANDS))) {
              ArteFoundModal arteModal =
                      new ArteFoundModal(
                              "weaponFound",
                              rndWeapon.toString(),
                              rndWeapon.getPhysDmg(),
                              rndWeapon.getMagicDmg());
              player.setWeaponType(rndWeapon);
              player.getStats().setMagicDmg(rndWeapon.getMagicDmg());
              player.getStats().setPhysDmg(rndWeapon.getPhysDmg());
              arteModal.showAndWait();
          } else {
              NothingFoundModel nothingFoundModel = new NothingFoundModel();
              nothingFoundModel.showAndWait();
          }
          getActionMenu().getChildren().remove(openBtn); // Remove openBtn once chest was opened
        });

    backButton.setOnMouseClicked(
        e -> {
          getScene().setRoot(new StartPane(player, "begining"));
        });
    addToActionMenu(openBtn, backButton);
  }
}
