package ir.maktab.presentation.cmd.playercmd;

import ir.maktab.entity.Player;
import ir.maktab.presentation.cmd.AbstractMenuCommand;
import ir.maktab.presentation.ui.Input;
import ir.maktab.presentation.ui.Output;
import ir.maktab.service.PlayerService;

public class AddPlayerCmd extends AbstractMenuCommand {

    private final PlayerService playerService = new PlayerService();

    public AddPlayerCmd(Integer selectNum, Output output) {
        super(selectNum, output);
    }

    @Override
    public void execute() {
        output.print("Enter player first name : ");
        String firstName = Input.getString();
        output.print("Enter player last name : ");
        String lastName = Input.getString();

        Player player = new Player();
        player.setFirstName(firstName);
        player.setLastName(lastName);

        playerService.saveOrUpdate(player);
    }
}
