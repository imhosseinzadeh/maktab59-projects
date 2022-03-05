package ir.maktab.presentation.cmd.seasoncmd;

import ir.maktab.entity.Season;
import ir.maktab.presentation.cmd.AbstractMenuCommand;
import ir.maktab.presentation.ui.Input;
import ir.maktab.presentation.ui.Output;
import ir.maktab.service.SeasonService;

public class AddSeasonCmd extends AbstractMenuCommand {

    private final SeasonService seasonService = new SeasonService();

    public AddSeasonCmd(Integer selectNum, Output output) {
        super(selectNum, output);
    }

    @Override
    public void execute() {
        output.print("Enter year : ");
        Long year = Input.getLong();
        Season season = new Season(year);
        seasonService.saveOrUpdate(season);
    }
}
