package ir.maktab.presentation.viewer.submenu;

import ir.maktab.presentation.cmd.AbstractMenuCommand;
import ir.maktab.presentation.cmd.playercmd.AddPlayerCmd;
import ir.maktab.presentation.cmd.playercmd.RemovePlayerCmd;
import ir.maktab.presentation.cmd.playercmd.UpdatePlayerCmd;
import ir.maktab.presentation.ui.Output;

import java.util.List;

public class PlayerMenu extends AbstractSubMenu {

    public PlayerMenu(Output output) {
        super(output);
    }

    @Override
    protected List<AbstractMenuCommand> initialCommand() {
        return List.of(
                new AddPlayerCmd(1, output),
                new RemovePlayerCmd(2, output),
                new UpdatePlayerCmd(3, output)
        );
    }

    @Override
    protected void menu() {
        output.print("""
                1)add player
                2)remove player
                3)update player
                4)Back
                """);
    }
}
