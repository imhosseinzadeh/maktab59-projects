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

public class UpdateGameCmd extends AbstractMenuCommand {

    private final GameService gameService = new GameService();
    private final ClubService clubService = new ClubService();
    private final StadiumService stadiumService = new StadiumService();
    private final SeasonService seasonService = new SeasonService();

    public UpdateGameCmd(Integer selectNum, Output output) {
        super(selectNum, output);
    }

    @Override
    public void execute() {

        output.print("Enter game id : ");
        Long gameId = Input.getLong();
        Game game = gameService.find(gameId);

        output.print("You are updating " + game + "\nCONTINUE y/n : ");
        if (Input.getString().toUpperCase().startsWith("Y")) {
            boolean showMenu = true;
            do {
                output.print("""
                        1)Change hostClub
                        2)Change guestClub
                        3)Change hostClub goals
                        4)Change guestClub goals
                        5)change Stadium
                        6)change Season
                        """);

                switch (Input.getInt()) {
                    case 1 -> changeHostClub(game);
                    case 2 -> changeGuestClub(game);
                    case 3 -> changeHostGoals(game);
                    case 4 -> changeGuestGoals(game);
                    case 5 -> changeStadium(game);
                    case 6 -> changeSeason(game);
                    default -> output.println("Wrong input");
                }
                gameService.saveOrUpdate(game);

                output.print("update another filed ? y/n : ");
                if (Input.getString().toUpperCase().startsWith("N")) {
                    showMenu = false;
                }

            } while (showMenu);
        }

    }

    private void changeHostClub(Game game) {
        output.println("===Club list===");
        clubService.findAll().forEach(club -> output.println(club.toString()));
        System.out.println("Enter new HostClub id : ");
        Long clubId = Input.getLong();
        Club newHostClub = clubService.find(clubId);
        game.setHostClub(newHostClub);
    }

    private void changeGuestClub(Game game) {
        clubService.findAll().forEach(club -> output.println(club.toString()));
        System.out.println("Enter new guestClub id : ");
        Long clubId = Input.getLong();
        Club newGuestClub = clubService.find(clubId);
        game.setGuestClub(newGuestClub);
    }

    private void changeHostGoals(Game game) {
        output.print("Enter new host goals : ");
        Integer newHostGoals = Input.getInt();
        setGoalsAndPoints(game, newHostGoals, game.getGuestGoals());
    }

    private void changeGuestGoals(Game game) {
        output.print("Enter new guest goals : ");
        Integer newGuestGoals = Input.getInt();
        setGoalsAndPoints(game, game.getHostGoals(), newGuestGoals);
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

    private void changeStadium(Game game) {
        stadiumService.findAll().forEach(stadium -> output.println(stadium.toString()));
        output.println("Enter new stadium id : ");
        Long stadiumId = Input.getLong();
        Stadium newStadium = stadiumService.find(stadiumId);
        game.setStadium(newStadium);
    }

    private void changeSeason(Game game) {
        output.println("Enter new season id(year) : ");
        Long seasonId = Input.getLong();
        Season season = seasonService.find(seasonId);
        game.setSeason(season);
    }


}
