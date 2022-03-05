package ir.maktab.presentation.cmd.clubcmd;

import ir.maktab.entity.City;
import ir.maktab.entity.Club;
import ir.maktab.presentation.cmd.AbstractMenuCommand;
import ir.maktab.presentation.ui.Input;
import ir.maktab.presentation.ui.Output;
import ir.maktab.service.CityService;
import ir.maktab.service.ClubService;

public class UpdateClubCmd extends AbstractMenuCommand {

    private final ClubService clubService = new ClubService();
    private final CityService cityService = new CityService();

    public UpdateClubCmd(Integer selectNum, Output output) {
        super(selectNum, output);
    }

    @Override
    public void execute() {
        output.print("Enter club id : ");
        Long clubId = Input.getLong();
        Club club = clubService.find(clubId);

        output.print("You are updating " + club + "\nCONTINUE y/n : ");
        if (Input.getString().toUpperCase().startsWith("Y")) {
            boolean showMenu = true;
            do {
                output.print("""
                        1)Change club name
                        2)Change club city
                        """);

                switch (Input.getInt()) {
                    case 1 -> changeClubName(club);
                    case 2 -> changeClubCity(club);
                    default -> output.println("Wrong input");
                }
                clubService.saveOrUpdate(club);

                output.print("update another filed ? y/n : ");
                if (Input.getString().toUpperCase().startsWith("N")) {
                    showMenu = false;
                }

            } while (showMenu);
        }

    }

    private void changeClubName(Club club) {
        output.print("Enter new name : ");
        String name = Input.getString();
        club.setName(name);
    }

    private void changeClubCity(Club club) {
        output.println("=== Cities list ===");
        cityService.findAll().forEach(city -> output.println(city.toString()));

        output.print("Enter this club new city id : ");
        Long cityId = Input.getLong();
        City city = cityService.find(cityId);

        output.print("Set " + city + " for club ? y/n : ");
        if (Input.getString().toUpperCase().startsWith("Y")) {
            club.setCity(city);
        }
    }
}
