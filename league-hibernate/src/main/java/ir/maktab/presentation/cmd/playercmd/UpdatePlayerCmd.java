package ir.maktab.presentation.cmd.playercmd;

import ir.maktab.entity.Player;
import ir.maktab.presentation.cmd.AbstractMenuCommand;
import ir.maktab.presentation.ui.Input;
import ir.maktab.presentation.ui.Output;
import ir.maktab.service.PlayerService;

public class UpdatePlayerCmd extends AbstractMenuCommand {

    private final PlayerService playerService = new PlayerService();

    public UpdatePlayerCmd(Integer selectNum, Output output) {
        super(selectNum, output);
    }

    @Override
    public void execute() {

        output.print("Enter player id : ");
        Long coachId = Input.getLong();
        Player loadPlayer = playerService.find(coachId);

        output.print("You are updating " + loadPlayer + "\nCONTINUE ? y/n : ");
        if (Input.getString().toUpperCase().startsWith("Y")) {
            output.print("Enter new player firstName : ");
            String firstName = Input.getString();
            loadPlayer.setFirstName(firstName);

            output.print("Enter new player lastName : ");
            String lastName = Input.getString();
            loadPlayer.setFirstName(lastName);

            playerService.saveOrUpdate(loadPlayer);
            output.println("Player updated");
        } else {
            output.println("Update canceled");
        }
    }
}
