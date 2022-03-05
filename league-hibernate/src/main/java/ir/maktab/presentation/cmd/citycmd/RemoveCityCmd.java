package ir.maktab.presentation.cmd.citycmd;

import ir.maktab.entity.City;
import ir.maktab.presentation.cmd.AbstractMenuCommand;
import ir.maktab.presentation.ui.Input;
import ir.maktab.presentation.ui.Output;
import ir.maktab.service.CityService;

public class RemoveCityCmd extends AbstractMenuCommand {

    private final CityService cityService = new CityService();

    public RemoveCityCmd(Integer selectNum, Output output) {
        super(selectNum, output);
    }

    @Override
    public void execute() {
        output.print("Enter city id : ");
        Long cityId = Input.getLong();
        City city = cityService.find(cityId);
        output.println("You will remove " + city + "\nCONTINUE ? y/n : ");
        if (Input.getString().toUpperCase().startsWith("Y")) {
            cityService.delete(city);
            output.println("City removed");
        } else {
            output.println("Remove canceled");
        }
    }
}
