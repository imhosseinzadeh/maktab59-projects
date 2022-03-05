package ir.maktab.presentation.viewer.submenu;

import ir.maktab.presentation.cmd.AbstractMenuCommand;
import ir.maktab.presentation.cmd.coachcmd.AddCoachCmd;
import ir.maktab.presentation.cmd.coachcmd.RemoveCoachCmd;
import ir.maktab.presentation.cmd.coachcmd.UpdateCoachCmd;
import ir.maktab.presentation.ui.Output;

import java.util.List;

public class CoachMenu extends AbstractSubMenu {

    public CoachMenu(Output output) {
        super(output);
    }

    @Override
    protected List<AbstractMenuCommand> initialCommand() {
        return List.of(
                new AddCoachCmd(1, output),
                new RemoveCoachCmd(2, output),
                new UpdateCoachCmd(3, output)
        );
    }

    @Override
    protected void menu() {
        output.print("""
                1)add coach
                2)remove coach
                3)update coach
                4)Back
                """);
    }
}
