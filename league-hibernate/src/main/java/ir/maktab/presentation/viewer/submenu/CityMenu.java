package ir.maktab.presentation.viewer.submenu;

import ir.maktab.presentation.cmd.AbstractMenuCommand;
import ir.maktab.presentation.cmd.citycmd.AddCityCmd;
import ir.maktab.presentation.cmd.citycmd.RemoveCityCmd;
import ir.maktab.presentation.cmd.citycmd.UpdateCityCmd;
import ir.maktab.presentation.ui.Output;

import java.util.List;

public class CityMenu extends AbstractSubMenu {

    public CityMenu(Output output) {
        super(output);
    }

    protected List<AbstractMenuCommand> initialCommand() {
        return List.of(
                new AddCityCmd(1, output),
                new RemoveCityCmd(2, output),
                new UpdateCityCmd(3, output)
        );
    }

    @Override
    protected void menu() {
        output.print("""
                1)Add City
                2)Remove City
                3)Update City
                4)Back
                """);
    }
}
