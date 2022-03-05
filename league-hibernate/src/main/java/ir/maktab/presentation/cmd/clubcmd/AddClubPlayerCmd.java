package ir.maktab.presentation.cmd.clubcmd;

import ir.maktab.entity.Club;
import ir.maktab.entity.ClubPlayer;
import ir.maktab.entity.Player;
import ir.maktab.entity.Season;
import ir.maktab.presentation.cmd.AbstractMenuCommand;
import ir.maktab.presentation.ui.Input;
import ir.maktab.presentation.ui.Output;
import ir.maktab.service.ClubPlayerService;
import ir.maktab.service.ClubService;
import ir.maktab.service.PlayerService;
import ir.maktab.service.SeasonService;

public class AddClubPlayerCmd extends AbstractMenuCommand {

    private final ClubPlayerService clubPlayerService = new ClubPlayerService();
    private final ClubService clubService = new ClubService();
    private final PlayerService playerService = new PlayerService();
    private final SeasonService seasonService = new SeasonService();

    public AddClubPlayerCmd(Integer selectNum, Output output) {
        super(selectNum, output);
    }

    @Override
    public void execute() {

        output.println("===Club list===");
        clubService.findAll().forEach(club -> output.println(club.toString()));
        output.print("Enter club id : ");
        Long clubId = Input.getLong();
        Club loadClub = clubService.find(clubId);

        output.println("===Player list===");
        playerService.findAll().forEach(player -> output.println(player.toString()));
        output.print("Enter player id : ");
        Long playerId = Input.getLong();
        Player loadPlayer = playerService.find(playerId);

        output.print("Enter season id(year) : ");
        Long seasonId = Input.getLong();
        Season loadSeason = seasonService.find(seasonId);

        output.print("Enter contract value :");
        Double contractValue = Input.getDouble();

        output.print("Enter salary :");
        Double salary = Input.getDouble();

        output.print("You will add " + loadPlayer + " to " + loadClub + " in " + loadSeason + "\nCONTINUE ? y/n : ");
        if (Input.getString().toUpperCase().startsWith("Y")) {
            ClubPlayer clubPlayer = generateClubPlayer(loadClub, loadPlayer, loadSeason);
            clubPlayer.setContractValue(contractValue);
            clubPlayer.setSalary(salary);

            clubPlayerService.saveOrUpdate(clubPlayer);

            output.println("Player added");
        } else {
            output.println("add canceled");
        }
    }

    private ClubPlayer generateClubPlayer(Club club, Player player, Season season) {
        ClubPlayer clubPlayer = new ClubPlayer();
        clubPlayer.setSeason(season);
        clubPlayer.setClub(club);
        clubPlayer.setPlayer(player);

        return clubPlayer;
    }
}
