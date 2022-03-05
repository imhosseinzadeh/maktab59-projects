package ir.maktab.presentation.cmd.gamecmd;

import ir.maktab.entity.Game;
import ir.maktab.presentation.cmd.AbstractMenuCommand;
import ir.maktab.presentation.ui.Input;
import ir.maktab.presentation.ui.Output;
import ir.maktab.service.GameService;

public class RemoveGameCmd extends AbstractMenuCommand {

    private final GameService gameService = new GameService();

    public RemoveGameCmd(Integer selectNum, Output output) {
        super(selectNum, output);
    }

    @Override
    public void execute() {
        output.print("Enter Game id : ");
        Long gameId = Input.getLong();
        Game game = gameService.find(gameId);
        output.print("You will remove " + game + "\nCONTINUE ? y/n : ");
        if (Input.getString().toUpperCase().startsWith("Y")) {
            gameService.delete(game);
            output.println("Game removed");
        } else {
            output.println("Removed canceled");
        }
    }
}
