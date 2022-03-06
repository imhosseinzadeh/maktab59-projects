package ir.maktab;

import ir.maktab.presentation.Menu;
import ir.maktab.presentation.ui.StandardOutput;

public class UniversityApplication {
    public static void main(String[] args) {
        new Menu(new StandardOutput()).startApplication();
    }
}
