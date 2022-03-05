package ir.maktab.presentation.viewer.submenu;

import ir.maktab.presentation.cmd.AbstractMenuCommand;
import ir.maktab.presentation.cmd.clubcmd.*;
import ir.maktab.presentation.ui.Output;

import java.util.List;

public class ClubMenu extends AbstractSubMenu {

    public ClubMenu(Output output) {
        super(output);
    }

    protected List<AbstractMenuCommand> initialCommand() {
        return List.of(
                new AddClubCmd(1, output),
                new RemoveClubCmd(2, output),
                new UpdateClubCmd(3, output),
                new AddClubCoachCmd(4, output),
                new RemoveClubCoachCmd(5, output),
                new AddClubPlayerCmd(6, output),
                new RemoveClubPlayerCmd(7, output)
        );
    }

    @Override
    protected void menu() {
        output.print("""
                1)Add Club
                2)Remove Club
                3)Update Club
                4)Add ClubCoach
                5)Remove ClubCoach
                6)Add ClubPlayer
                7)Remove ClubPlayer
                8)Back
                """);
    }
}
