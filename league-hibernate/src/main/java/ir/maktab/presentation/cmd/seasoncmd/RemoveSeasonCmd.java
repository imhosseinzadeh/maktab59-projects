package ir.maktab.presentation.cmd.seasoncmd;

import ir.maktab.entity.Season;
import ir.maktab.presentation.cmd.AbstractMenuCommand;
import ir.maktab.presentation.ui.Input;
import ir.maktab.presentation.ui.Output;
import ir.maktab.service.SeasonService;

public class RemoveSeasonCmd extends AbstractMenuCommand {

    private final SeasonService seasonService = new SeasonService();

    public RemoveSeasonCmd(Integer selectNum, Output output) {
        super(selectNum, output);
    }

    @Override
    public void execute() {
        output.print("Enter season id(year) : ");
        Long seasonId = Input.getLong();
        Season season = seasonService.find(seasonId);
        seasonService.delete(season);
    }
}
