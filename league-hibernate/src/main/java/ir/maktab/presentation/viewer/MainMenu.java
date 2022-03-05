package ir.maktab.presentation.viewer;

import ir.maktab.presentation.ui.Input;
import ir.maktab.presentation.ui.Output;
import ir.maktab.presentation.viewer.submenu.*;

import java.util.List;

public class MainMenu {

    private final Output output;
    private final List<AbstractSubMenu> subMenus;

    public MainMenu(Output output) {
        this.output = output;
        this.subMenus = initialSubMenus();
    }

    private List<AbstractSubMenu> initialSubMenus() {
        return List.of(
                new CityMenu(output),
                new ClubMenu(output),
                new StadiumMenu(output),
                new SeasonMenu(output),
                new CoachMenu(output),
                new PlayerMenu(output),
                new GameMenu(output)
        );
    }

    public void startApplication() {
        boolean showMenu = true;
        while (showMenu) {
            menu();
            showMenu = chooseMenu();
        }
        output.print("SEE YOU LATER");
    }

    private boolean chooseMenu() {
        int selected = Input.getInt();
        if (selected > subMenus.size()) {
            return false;
        }
        subMenus.get(selected - 1).start();
        return true;
    }

    private void menu() {
        output.print("""
                1)City Menu
                2)Club Menu
                3)Stadium Menu
                4)Season Menu
                5)Coach Menu
                6)Player Menu
                7)Game Menu
                8)EXIT
                """);
    }
}
