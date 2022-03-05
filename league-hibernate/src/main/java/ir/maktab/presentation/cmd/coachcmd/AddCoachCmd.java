package ir.maktab.presentation.cmd.coachcmd;

import ir.maktab.entity.Coach;
import ir.maktab.presentation.cmd.AbstractMenuCommand;
import ir.maktab.presentation.ui.Input;
import ir.maktab.presentation.ui.Output;
import ir.maktab.service.CoachService;

public class AddCoachCmd extends AbstractMenuCommand {

    private final CoachService coachService = new CoachService();

    public AddCoachCmd(Integer selectNum, Output output) {
        super(selectNum, output);
    }

    @Override
    public void execute() {
        output.print("Enter coach first name : ");
        String firstName = Input.getString();
        output.print("Enter coach last name : ");
        String lastName = Input.getString();

        Coach coach = new Coach();
        coach.setFirstName(firstName);
        coach.setLastName(lastName);

        coachService.saveOrUpdate(coach);
    }
}
