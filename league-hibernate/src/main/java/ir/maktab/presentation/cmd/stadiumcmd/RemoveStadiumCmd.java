package ir.maktab.presentation.cmd.stadiumcmd;

import ir.maktab.entity.Stadium;
import ir.maktab.presentation.cmd.AbstractMenuCommand;
import ir.maktab.presentation.ui.Input;
import ir.maktab.presentation.ui.Output;
import ir.maktab.service.StadiumService;

public class RemoveStadiumCmd extends AbstractMenuCommand {

    private final StadiumService stadiumService = new StadiumService();

    public RemoveStadiumCmd(Integer selectNum, Output output) {
        super(selectNum, output);
    }

    @Override
    public void execute() {
        output.print("Enter stadium id : ");
        Long stadiumId = Input.getLong();
        Stadium stadium = stadiumService.find(stadiumId);
        output.print("You will remove " + stadium + "\nCONTINUE ? y/n : ");
        if (Input.getString().toUpperCase().startsWith("Y")) {
            stadiumService.delete(stadium);
            output.println("Stadium removed");
        } else {
            output.println("Removed canceled");
        }
    }
}
