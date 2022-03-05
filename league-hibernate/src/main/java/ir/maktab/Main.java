package ir.maktab;

import ir.maktab.presentation.ui.StandardOutput;
import ir.maktab.presentation.viewer.MainMenu;

public class Main {
    public static void main(String[] args) {
        new MainMenu(new StandardOutput()).startApplication();
    }
}
