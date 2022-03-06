package ir.maktab.presentation;

import ir.maktab.presentation.cmd.*;
import ir.maktab.presentation.ui.Input;
import ir.maktab.presentation.ui.Output;

import java.util.List;

public class Menu {

    private final Output output;
    private final MenuCommandExecutor menuCommandExecutor;

    public Menu(Output output) {
        this.output = output;
        this.menuCommandExecutor = new MenuCommandExecutor(initialCommand());
    }

    private List<MenuCommand> initialCommand() {
        return List.of(
                new SignUpCmd(),
                new ShowUniversityCoursesCmd(),
                new ShowStudentCourseCmd(),
                new AddCourseCmd(),
                new RemoveCourseCmd()
        );
    }

    public void startApplication() {
        boolean showMenu = true;
        while (showMenu) {
            menu();
            showMenu = chooseMenu();
        }
        output.close("Exit");
    }

    private boolean chooseMenu() {
        int selected = Input.getInt();
        if (selected >= 6) {
            return false;
        }
        menuCommandExecutor.execute(selected);
        return true;
    }

    public void menu() {
        output.print("""
                1) SignUp
                2) Show University courses
                3) Show student courses
                4) Add course
                5) Remove course
                6) Exit
                """);
    }
}
