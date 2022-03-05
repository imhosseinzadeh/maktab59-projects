package ir.maktab.presentation.cmd.coachcmd;

import ir.maktab.entity.Coach;
import ir.maktab.presentation.cmd.AbstractMenuCommand;
import ir.maktab.presentation.ui.Input;
import ir.maktab.presentation.ui.Output;
import ir.maktab.service.CoachService;

public class UpdateCoachCmd extends AbstractMenuCommand {

    private final CoachService coachService = new CoachService();

    public UpdateCoachCmd(Integer selectNum, Output output) {
        super(selectNum, output);
    }

    @Override
    public void execute() {
        output.print("Enter coach id : ");
        Long coachId = Input.getLong();
        Coach loadCoach = coachService.find(coachId);

        output.print("You are updating " + loadCoach + "\nCONTINUE ? y/n : ");
        if (Input.getString().toUpperCase().startsWith("Y")) {
            output.print("Enter new coach firstName : ");
            String firstName = Input.getString();
            loadCoach.setFirstName(firstName);

            output.print("Enter new coach lastName : ");
            String lastName = Input.getString();
            loadCoach.setFirstName(lastName);

            coachService.saveOrUpdate(loadCoach);
            output.println("Coach updated");
        } else {
            output.println("Update canceled");
        }
    }
}
