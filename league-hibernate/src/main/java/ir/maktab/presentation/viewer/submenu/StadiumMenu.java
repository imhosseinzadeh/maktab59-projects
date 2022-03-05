package ir.maktab.presentation.viewer.submenu;

import ir.maktab.presentation.cmd.AbstractMenuCommand;
import ir.maktab.presentation.cmd.stadiumcmd.AddStadiumCmd;
import ir.maktab.presentation.cmd.stadiumcmd.RemoveStadiumCmd;
import ir.maktab.presentation.cmd.stadiumcmd.UpdateStadiumCmd;
import ir.maktab.presentation.ui.Output;

import java.util.List;

public class StadiumMenu extends AbstractSubMenu {

    public StadiumMenu(Output output) {
        super(output);
    }

    @Override
    protected List<AbstractMenuCommand> initialCommand() {
        return List.of(
                new AddStadiumCmd(1, output),
                new RemoveStadiumCmd(2, output),
                new UpdateStadiumCmd(3, output)
        );
    }

    @Override
    protected void menu() {
        output.print("""
                1)Add Stadium
                2)Remove Stadium
                3)Update Stadium
                4)Back
                """);
    }
}
