package ir.maktab.presentation.viewer.submenu;

import ir.maktab.presentation.cmd.AbstractMenuCommand;
import ir.maktab.presentation.cmd.gamecmd.AddGameCmd;
import ir.maktab.presentation.cmd.gamecmd.RemoveGameCmd;
import ir.maktab.presentation.cmd.gamecmd.UpdateGameCmd;
import ir.maktab.presentation.ui.Output;

import java.util.List;

public class GameMenu extends AbstractSubMenu {

    public GameMenu(Output output) {
        super(output);
    }

    @Override
    protected List<AbstractMenuCommand> initialCommand() {
        return List.of(
                new AddGameCmd(1, output),
                new RemoveGameCmd(2, output),
                new UpdateGameCmd(3, output)
        );
    }

    @Override
    protected void menu() {
        output.print("""
                1)Add Game
                2)Remove Game
                3)Update Game
                4)Back
                """);
    }
}
