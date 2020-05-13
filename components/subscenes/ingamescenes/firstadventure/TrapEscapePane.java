package components.subscenes.ingamescenes.firstadventure;

import components.buttons.DefaultButton;
import components.buttons.GoBackButton;
import components.modals.ArteFoundModal;
import components.modals.NothingFoundModel;
import entities.player.ArmorType;
import entities.player.Player;
import utils.GetRandomType;

public class TrapEscapePane extends AbstracPane {
  public TrapEscapePane(Player player, String textname) {
    super(player, textname);
    DefaultButton checkBtn  = new DefaultButton("Check");
    GoBackButton backButton = new GoBackButton();

    checkBtn.setOnMouseClicked(
        e -> {
          ArmorType rndArmor = GetRandomType.randomEnum(ArmorType.class);
          if (!(rndArmor.equals(ArmorType.CLOTHES))) {
              ArteFoundModal arteModel =
                      new ArteFoundModal(
                              "armorFound",
                              rndArmor.toString(),
                              rndArmor.getPhysDef(),
                              rndArmor.getMagDef());
              player.setArmorType(rndArmor);
              player.setMagicDef();
              player.setPhysDef();
              arteModel.showAndWait();
          } else {
              NothingFoundModel nothingFoundModel = new NothingFoundModel();
              nothingFoundModel.showAndWait();
          }
          getActionMenu().getChildren().remove(checkBtn);
        });

    backButton.setOnMouseClicked(
        e -> {
          getScene().setRoot(new StartPane(player, "begining"));
        });

    addToActionMenu(checkBtn, backButton);
  }
}
