package ir.maktab.presentation.cmd.clubcmd;

import ir.maktab.entity.*;
import ir.maktab.presentation.cmd.AbstractMenuCommand;
import ir.maktab.presentation.ui.Input;
import ir.maktab.presentation.ui.Output;
import ir.maktab.service.ClubPlayerService;
import ir.maktab.service.ClubService;
import ir.maktab.service.PlayerService;
import ir.maktab.service.SeasonService;

import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class RemoveClubPlayerCmd extends AbstractMenuCommand {

    private final ClubPlayerService clubPlayerService = new ClubPlayerService();
    private final ClubService clubService = new ClubService();
    private final PlayerService playerService = new PlayerService();
    private final SeasonService seasonService = new SeasonService();

    public RemoveClubPlayerCmd(Integer selectNum, Output output) {
        super(selectNum, output);
    }

    @Override
    public void execute() {
        output.print("Enter club id : ");
        Long clubId = Input.getLong();
        Club loadClub = clubService.find(clubId);

        output.println("===Club players list===");
        loadClub.getClubPlayers().forEach(clubPlayer -> output.println(clubPlayer.getPlayer().toString()));
        output.print("Enter player id to remove : ");
        Long playerId = Input.getLong();
        Player loadPlayer = playerService.find(playerId);

        printPlayerSeasonInAClub(loadClub, loadPlayer);

        output.print("Enter season id(year) : ");
        Long seasonId = Input.getLong();
        Season loadSeason = seasonService.find(seasonId);


        output.print("You will remove " + loadPlayer + " in club " + loadClub + " from " + loadSeason + "\nCONTINUE ? y/n : ");
        if (Input.getString().toUpperCase().startsWith("Y")) {
            ClubPlayer clubPlayer = generateClubPlayer(loadClub, loadPlayer, loadSeason);
            clubPlayerService.delete(clubPlayer);
            output.println("Player remove from season");
        } else {
            output.println("remove canceled");
        }
    }

    private ClubPlayer generateClubPlayer(Club club, Player player, Season season) {
        ClubPlayer clubPlayer = new ClubPlayer();
        clubPlayer.setSeason(season);
        clubPlayer.setClub(club);
        clubPlayer.setPlayer(player);

        ClubPlayerId clubPlayerId = new ClubPlayerId();
        clubPlayerId.setClubId(club.getId());
        clubPlayerId.setPlayerId(player.getId());
        clubPlayerId.setSeasonId(season.getId());

        clubPlayer.setId(clubPlayerId);

        return clubPlayer;
    }

    private void printPlayerSeasonInAClub(Club club, Player player) {
        Predicate<ClubPlayer> checkClub = clubPlayer -> clubPlayer.getClub().equals(club);

        Set<ClubPlayer> playerSeasonInAClub = player.getClubPlayers().stream()
                .filter(checkClub).collect(Collectors.toSet());

        output.println("this Player worked in these season in  " + club);
        playerSeasonInAClub.forEach(clubPlayer -> output.println(clubPlayer.getSeason().toString()));
    }
}
