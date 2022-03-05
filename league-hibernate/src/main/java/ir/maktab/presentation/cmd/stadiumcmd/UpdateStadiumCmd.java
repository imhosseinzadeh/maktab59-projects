package ir.maktab.presentation.cmd.stadiumcmd;

import ir.maktab.entity.City;
import ir.maktab.entity.Stadium;
import ir.maktab.presentation.cmd.AbstractMenuCommand;
import ir.maktab.presentation.ui.Input;
import ir.maktab.presentation.ui.Output;
import ir.maktab.service.CityService;
import ir.maktab.service.StadiumService;

public class UpdateStadiumCmd extends AbstractMenuCommand {

    private final StadiumService stadiumService = new StadiumService();
    private final CityService cityService = new CityService();

    public UpdateStadiumCmd(Integer selectNum, Output output) {
        super(selectNum, output);
    }

    @Override
    public void execute() {

        output.print("Enter Stadium id : ");
        Long stadiumId = Input.getLong();
        Stadium stadium = stadiumService.find(stadiumId);

        output.print("You are updating " + stadium + "\nCONTINUE y/n : ");
        if (Input.getString().toUpperCase().startsWith("Y")) {
            boolean showMenu = true;
            do {
                output.print("""
                        1)Change stadium name
                        2)Change stadium capacity
                        3)Change stadium city
                        """);

                switch (Input.getInt()) {
                    case 1 -> changeStadiumName(stadium);
                    case 2 -> changeStadiumCapacity(stadium);
                    case 3 -> changeStadiumCity(stadium);
                    default -> output.println("Wrong input");
                }
                stadiumService.saveOrUpdate(stadium);

                output.print("update another filed ? y/n : ");
                if (Input.getString().toUpperCase().startsWith("N")) {
                    showMenu = false;
                }
            } while (showMenu);
        }
    }

    private void changeStadiumCapacity(Stadium stadium) {
        output.print("Enter new capacity : ");
        Integer capacity = Input.getInt();
        stadium.setCapacity(capacity);
    }

    private void changeStadiumName(Stadium stadium) {
        output.print("Enter new name : ");
        String name = Input.getString();
        stadium.setName(name);
    }

    private void changeStadiumCity(Stadium stadium) {
        output.println("=== City list ===");
        cityService.findAll().forEach(System.out::println);

        output.print("Enter this stadium new city id : ");
        Long cityId = Input.getLong();
        City city = cityService.find(cityId);

        output.print("Set " + city + " for stadium ? y/n : ");
        if (Input.getString().toUpperCase().startsWith("Y")) {
            stadium.setCity(city);
        }
    }
}
