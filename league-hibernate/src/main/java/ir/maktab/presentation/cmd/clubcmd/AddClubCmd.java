package ir.maktab.presentation.cmd.clubcmd;

import ir.maktab.entity.City;
import ir.maktab.entity.Club;
import ir.maktab.presentation.cmd.AbstractMenuCommand;
import ir.maktab.presentation.ui.Input;
import ir.maktab.presentation.ui.Output;
import ir.maktab.service.CityService;
import ir.maktab.service.ClubService;

public class AddClubCmd extends AbstractMenuCommand {

    private final ClubService clubService = new ClubService();
    private final CityService cityService = new CityService();

    public AddClubCmd(Integer selectNum, Output output) {
        super(selectNum, output);
    }

    @Override
    public void execute() {
        output.print("Enter club name : ");
        Club club = new Club(Input.getString());
        output.println("=== Cities list ===");
        cityService.findAll().forEach(city -> output.println(city.toString()));
        output.print("Enter this club city id : ");
        City city = cityService.find(Input.getLong());
        club.setCity(city);
        clubService.saveOrUpdate(club);
    }
}
