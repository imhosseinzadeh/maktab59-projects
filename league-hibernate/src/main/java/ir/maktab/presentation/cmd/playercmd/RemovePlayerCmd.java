package ir.maktab.presentation.cmd.playercmd;

import ir.maktab.entity.Player;
import ir.maktab.presentation.cmd.AbstractMenuCommand;
import ir.maktab.presentation.ui.Input;
import ir.maktab.presentation.ui.Output;
import ir.maktab.service.PlayerService;

public class RemovePlayerCmd extends AbstractMenuCommand {

    private final PlayerService playerService = new PlayerService();

    public RemovePlayerCmd(Integer selectNum, Output output) {
        super(selectNum, output);
    }

    @Override
    public void execute() {
        output.print("Enter player id : ");
        Long playerId = Input.getLong();
        Player loadPlayer = playerService.find(playerId);

        output.print("You will remove " + loadPlayer + "\nCONTINUE ? y/n : ");
        if (Input.getString().toUpperCase().startsWith("Y")) {
            playerService.delete(loadPlayer);
            output.println("Player removed");
        } else {
            output.println("Removed canceled");
        }
    }
}
