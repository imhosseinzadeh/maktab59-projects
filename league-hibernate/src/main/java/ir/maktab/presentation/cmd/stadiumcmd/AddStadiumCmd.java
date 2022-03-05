package ir.maktab.presentation.cmd.stadiumcmd;

import ir.maktab.entity.City;
import ir.maktab.entity.Stadium;
import ir.maktab.presentation.cmd.AbstractMenuCommand;
import ir.maktab.presentation.ui.Input;
import ir.maktab.presentation.ui.Output;
import ir.maktab.service.CityService;
import ir.maktab.service.StadiumService;

public class AddStadiumCmd extends AbstractMenuCommand {

    private final StadiumService stadiumService = new StadiumService();
    private final CityService cityService = new CityService();

    public AddStadiumCmd(Integer selectNum, Output output) {
        super(selectNum, output);
    }

    @Override
    public void execute() {
        output.print("Enter stadium name : ");
        String name = Input.getString();

        output.print("Enter stadium capacity : ");
        Integer capacity = Input.getInt();

        output.println("===City list===");
        cityService.findAll().forEach(city -> output.println(city.toString()));
        output.print("Enter this stadium city id : ");
        Long cityId = Input.getLong();
        City city = cityService.find(cityId);

        Stadium stadium = new Stadium(name, capacity);
        stadium.setCity(city);

        stadiumService.saveOrUpdate(stadium);
    }
}
