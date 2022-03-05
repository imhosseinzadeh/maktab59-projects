package ir.maktab.presentation.cmd.clubcmd;

import ir.maktab.entity.*;
import ir.maktab.presentation.cmd.AbstractMenuCommand;
import ir.maktab.presentation.ui.Input;
import ir.maktab.presentation.ui.Output;
import ir.maktab.service.ClubCoachService;
import ir.maktab.service.ClubService;
import ir.maktab.service.CoachService;
import ir.maktab.service.SeasonService;

import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class RemoveClubCoachCmd extends AbstractMenuCommand {

    private final ClubCoachService clubCoachService = new ClubCoachService();
    private final ClubService clubService = new ClubService();
    private final CoachService coachService = new CoachService();
    private final SeasonService seasonService = new SeasonService();

    public RemoveClubCoachCmd(Integer selectNum, Output output) {
        super(selectNum, output);
    }

    @Override
    public void execute() {
        output.print("Enter club id : ");
        Long clubId = Input.getLong();
        Club loadClub = clubService.find(clubId);

        output.println("===Club coaches list===");
        loadClub.getClubCoaches().forEach(clubCoach -> output.println(clubCoach.getCoach().toString()));
        output.print("Enter coach id to remove : ");
        Long coachId = Input.getLong();
        Coach loadCoach = coachService.find(coachId);

        printCoachSeasonInAClub(loadClub, loadCoach);

        output.print("Enter season id(year) : ");
        Long seasonId = Input.getLong();
        Season loadSeason = seasonService.find(seasonId);


        output.print("You will remove " + loadCoach + " in club " + loadClub + " from " + loadSeason + "\nCONTINUE ? y/n : ");
        if (Input.getString().toUpperCase().startsWith("Y")) {
            ClubCoach clubCoach = generateClubCoach(loadClub, loadCoach, loadSeason);
            clubCoachService.delete(clubCoach);
            output.println("Coach remove from season");
        } else {
            output.println("remove canceled");
        }

    }

    private ClubCoach generateClubCoach(Club club, Coach coach, Season season) {
        ClubCoach clubCoach = new ClubCoach();
        clubCoach.setClub(club);
        clubCoach.setCoach(coach);
        clubCoach.setSeason(season);

        ClubCoachId clubCoachId = new ClubCoachId();
        clubCoachId.setClubId(club.getId());
        clubCoachId.setCoachId(coach.getId());
        clubCoachId.setSeasonId(season.getId());

        clubCoach.setId(clubCoachId);

        return clubCoach;
    }

    private void printCoachSeasonInAClub(Club club, Coach coach) {
        Predicate<ClubCoach> checkClub = clubCoach -> clubCoach.getClub().equals(club);

        Set<ClubCoach> coachSeasonInAClub = coach.getClubCoaches().stream()
                .filter(checkClub).collect(Collectors.toSet());

        output.println("this Coach worked in these season in  " + club);
        coachSeasonInAClub.forEach(clubCoach -> output.println(clubCoach.getSeason().toString()));
    }

}
