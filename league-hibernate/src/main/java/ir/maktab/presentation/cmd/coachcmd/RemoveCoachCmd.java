package ir.maktab.presentation.cmd.coachcmd;

import ir.maktab.entity.Coach;
import ir.maktab.presentation.cmd.AbstractMenuCommand;
import ir.maktab.presentation.ui.Input;
import ir.maktab.presentation.ui.Output;
import ir.maktab.service.CoachService;

public class RemoveCoachCmd extends AbstractMenuCommand {

    private final CoachService coachService = new CoachService();

    public RemoveCoachCmd(Integer selectNum, Output output) {
        super(selectNum, output);
    }

    @Override
    public void execute() {
        output.print("Enter coach id : ");
        Long coachId = Input.getLong();
        Coach loadCoach = coachService.find(coachId);

        output.print("You will remove " + loadCoach + "\nCONTINUE ? y/n : ");
        if (Input.getString().toUpperCase().startsWith("Y")) {
            coachService.delete(loadCoach);
            output.println("Coach removed");
        } else {
            output.println("Removed canceled");
        }

    }
}
