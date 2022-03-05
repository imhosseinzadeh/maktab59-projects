package ir.maktab.presentation.cmd.citycmd;

import ir.maktab.entity.City;
import ir.maktab.presentation.cmd.AbstractMenuCommand;
import ir.maktab.presentation.ui.Input;
import ir.maktab.presentation.ui.Output;
import ir.maktab.service.CityService;

public class AddCityCmd extends AbstractMenuCommand {

    private final CityService cityService = new CityService();

    public AddCityCmd(Integer selectNum, Output output) {
        super(selectNum, output);
    }

    @Override
    public void execute() {
        output.print("Enter city name : ");
        String name = Input.getString();
        City city = new City(name);
        cityService.saveOrUpdate(city);
    }
}
