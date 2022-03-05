package ir.maktab.presentation.cmd.clubcmd;

import ir.maktab.entity.Club;
import ir.maktab.entity.ClubCoach;
import ir.maktab.entity.Coach;
import ir.maktab.entity.Season;
import ir.maktab.presentation.cmd.AbstractMenuCommand;
import ir.maktab.presentation.ui.Input;
import ir.maktab.presentation.ui.Output;
import ir.maktab.service.ClubCoachService;
import ir.maktab.service.ClubService;
import ir.maktab.service.CoachService;
import ir.maktab.service.SeasonService;

public class AddClubCoachCmd extends AbstractMenuCommand {

    private final ClubCoachService clubCoachService = new ClubCoachService();
    private final ClubService clubService = new ClubService();
    private final CoachService coachService = new CoachService();
    private final SeasonService seasonService = new SeasonService();

    public AddClubCoachCmd(Integer selectNum, Output output) {
        super(selectNum, output);
    }

    @Override
    public void execute() {

        output.println("===Club list===");
        clubService.findAll().forEach(club -> output.println(club.toString()));
        output.print("Enter club id : ");
        Long clubId = Input.getLong();
        Club loadClub = clubService.find(clubId);

        output.println("===Coach list===");
        coachService.findAll().forEach(coach -> output.println(coach.toString()));
        output.print("Enter coach id : ");
        Long coachId = Input.getLong();
        Coach loadCoach = coachService.find(coachId);

        output.print("Enter season id(year) : ");
        Long seasonId = Input.getLong();
        Season loadSeason = seasonService.find(seasonId);

        output.print("Enter contract value :");
        Double contractValue = Input.getDouble();

        output.print("Enter salary :");
        Double salary = Input.getDouble();

        output.print("You will add " + loadCoach + " to " + loadClub + " in " + loadSeason + "\nCONTINUE ? y/n : ");
        if (Input.getString().toUpperCase().startsWith("Y")) {
            ClubCoach clubCoach = generateClubCoach(loadClub, loadCoach, loadSeason);
            clubCoach.setContractValue(contractValue);
            clubCoach.setSalary(salary);

            clubCoachService.saveOrUpdate(clubCoach);

            output.println("Coach added");
        } else {
            output.println("add canceled");
        }

    }

    private ClubCoach generateClubCoach(Club club, Coach coach, Season season) {
        ClubCoach clubCoach = new ClubCoach();
        clubCoach.setClub(club);
        clubCoach.setCoach(coach);
        clubCoach.setSeason(season);

        return clubCoach;
    }
}
