package ir.maktab.presentation.viewer.submenu;

import ir.maktab.presentation.cmd.AbstractMenuCommand;
import ir.maktab.presentation.cmd.MenuCommandExecutor;
import ir.maktab.presentation.ui.Input;
import ir.maktab.presentation.ui.Output;

import java.util.List;

public abstract class AbstractSubMenu {

    protected final Output output;
    private final MenuCommandExecutor menuCommandExecutor;

    AbstractSubMenu(Output output) {
        this.output = output;
        this.menuCommandExecutor = new MenuCommandExecutor(initialCommand());
    }

    protected abstract List<AbstractMenuCommand> initialCommand();

    public void start() {
        boolean showMenu = true;
        while (showMenu) {
            menu();
            showMenu = chooseMenu();
        }
    }

    private boolean chooseMenu() {
        int selected = Input.getInt();
        if (selected > menuCommandExecutor.size()) {
            return false;
        }
        menuCommandExecutor.execute(selected);
        return true;
    }

    protected abstract void menu();
}
