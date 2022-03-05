package ir.maktab.presentation.cmd.clubcmd;

import ir.maktab.entity.Club;
import ir.maktab.presentation.cmd.AbstractMenuCommand;
import ir.maktab.presentation.ui.Input;
import ir.maktab.presentation.ui.Output;
import ir.maktab.service.ClubService;

public class RemoveClubCmd extends AbstractMenuCommand {

    private final ClubService clubService = new ClubService();

    public RemoveClubCmd(Integer selectNum, Output output) {
        super(selectNum, output);
    }

    @Override
    public void execute() {
        output.print("Enter Club id : ");
        Long clubId = Input.getLong();
        Club club = clubService.find(clubId);
        output.print("You will remove " + club + "\nCONTINUE ? y/n : ");
        if (Input.getString().toUpperCase().startsWith("Y")) {
            clubService.delete(club);
            output.println("Club removed");
        } else {
            output.println("Removed canceled");
        }
    }
}
