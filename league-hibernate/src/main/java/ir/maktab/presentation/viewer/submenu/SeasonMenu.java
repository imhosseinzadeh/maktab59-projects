package ir.maktab.presentation.viewer.submenu;

import ir.maktab.presentation.cmd.AbstractMenuCommand;
import ir.maktab.presentation.cmd.seasoncmd.AddSeasonCmd;
import ir.maktab.presentation.cmd.seasoncmd.RemoveSeasonCmd;
import ir.maktab.presentation.ui.Output;

import java.util.List;

public class SeasonMenu extends AbstractSubMenu {

    public SeasonMenu(Output output) {
        super(output);
    }

    @Override
    protected List<AbstractMenuCommand> initialCommand() {
        return List.of(
                new AddSeasonCmd(1, output),
                new RemoveSeasonCmd(2, output)
        );
    }

    @Override
    protected void menu() {
        output.print("""
                1)Add Season
                2)remove Season
                3)Back
                """);
    }
}
