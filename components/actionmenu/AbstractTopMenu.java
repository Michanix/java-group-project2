package components.actionmenu;

import components.StartGameManager;
import components.modals.HelpWindow;
import javafx.scene.control.*;
import javafx.stage.Stage;

public abstract class AbstractTopMenu extends MenuBar {
  private final Menu settings = new Menu("Settings");

  public AbstractTopMenu() {
    CustomMenuItem backToMenuItem = createCustomMenuBtn("Main menu");
    CustomMenuItem helpBtnItem    = createCustomMenuBtn("Help");
    backToMenuItem.setOnAction(
        e -> {
          StartGameManager mainMenu = new StartGameManager();
          mainMenu.startGameMan((Stage) this.getScene().getWindow());
        });

    helpBtnItem.setOnAction(
        e -> {
          HelpWindow helpWindow = new HelpWindow();
          helpWindow.showAndWait();
        });
    addToSettings(backToMenuItem, helpBtnItem);
    getMenus().setAll(settings);
  }

  public CustomMenuItem createCustomMenuBtn(String text) {
    Button btn = new Button(text);
    btn.setStyle("-fx-background-color: transparent;");
    return new CustomMenuItem(btn);
  }

  /*
  Helper function to reduce repetitive code.
  Helps create Menu and Items inside of it in range from 1 to many.
   */
  public Menu createMenuWithItems(String menuName, String... menuItemText) {
    Menu menu = new Menu(menuName);
    for (String txt : menuItemText) {
      menu.getItems().add(new MenuItem(txt));
    }
    return menu;
  }

  public void addToSettings(MenuItem... menuItem) {
    settings.getItems().addAll(menuItem);
  }

  public void addMenus(Menu... menus) {
    getMenus().addAll(menus);
  }
}
