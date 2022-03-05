package ir.maktab.presentation.cmd.gamecmd;

import ir.maktab.entity.Club;
import ir.maktab.entity.Game;
import ir.maktab.entity.Season;
import ir.maktab.entity.Stadium;
import ir.maktab.presentation.cmd.AbstractMenuCommand;
import ir.maktab.presentation.ui.Input;
import ir.maktab.presentation.ui.Output;
import ir.maktab.service.ClubService;
import ir.maktab.service.GameService;
import ir.maktab.service.SeasonService;
import ir.maktab.service.StadiumService;

public class AddGameCmd extends AbstractMenuCommand {

    private final GameService gameService = new GameService();
    private final ClubService clubService = new ClubService();
    private final StadiumService stadiumService = new StadiumService();
    private final SeasonService seasonService = new SeasonService();

    public AddGameCmd(Integer selectNum, Output output) {
        super(selectNum, output);
    }

    @Override
    public void execute() {
        Game game = new Game();

        output.print("Enter season id (year) : ");
        Long seasonId = Input.getLong();
        Season season = seasonService.find(seasonId);
        game.setSeason(season);

        output.println("===Stadium list===");
        stadiumService.findAll().forEach(stadium -> output.println(stadium.toString()));
        output.print("Enter stadium id : ");
        Long stadiumId = Input.getLong();
        Stadium stadium = stadiumService.find(stadiumId);
        game.setStadium(stadium);

        output.println("===Clubs list===");
        clubService.findAll().forEach(club -> output.println(club.toString()));

        output.print("Enter hostClub id : ");
        Long hostClubId = Input.getLong();
        Club hostClub = clubService.find(hostClubId);
        game.setHostClub(hostClub);

        output.print("Enter guestClub id : ");
        Long guestClubId = Input.getLong();
        Club guestClub = clubService.find(guestClubId);
        game.setGuestClub(guestClub);

        System.out.print("Enter hostGoals : ");
        Integer hostGoals = Input.getInt();

        System.out.print("Enter guestGoals : ");
        Integer guestGoals = Input.getInt();

        setGoalsAndPoints(game, hostGoals, guestGoals);

        gameService.saveOrUpdate(game);
    }

    private void setGoalsAndPoints(Game game, int hostGoals, int guestGoals) {
        game.setHostGoals(hostGoals);
        game.setGuestGoals(guestGoals);

        if (hostGoals > guestGoals) {
            game.setHostPoint(3);
            game.setGuestPoint(0);
        } else if (hostGoals < guestGoals) {
            game.setHostPoint(0);
            game.setGuestPoint(3);
        } else {
            game.setHostPoint(1);
            game.setGuestPoint(1);
        }
    }
}
