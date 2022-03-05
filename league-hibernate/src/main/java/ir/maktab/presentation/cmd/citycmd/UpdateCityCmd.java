package ir.maktab.presentation.cmd.citycmd;

import ir.maktab.entity.City;
import ir.maktab.presentation.cmd.AbstractMenuCommand;
import ir.maktab.presentation.ui.Input;
import ir.maktab.presentation.ui.Output;
import ir.maktab.service.CityService;

public class UpdateCityCmd extends AbstractMenuCommand {

    private final CityService cityService = new CityService();

    public UpdateCityCmd(Integer selectNum, Output output) {
        super(selectNum, output);
    }

    @Override
    public void execute() {
        output.print("Enter city id : ");
        Long clubId = Input.getLong();
        City city = cityService.find(clubId);

        output.print("You are updating " + city + "\nCONTINUE ? y/n : ");
        if (Input.getString().toUpperCase().startsWith("Y")) {
            output.println("Enter new city name : ");
            String name = Input.getString();
            city.setName(name);

            cityService.saveOrUpdate(city);
            output.println("City updated");
        } else {
            output.println("Update canceled");
        }

    }
}
