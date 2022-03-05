package ir.maktab.presentation.ui;

import ir.maktab.exception.InvalidDataException;

import java.util.Scanner;

public class Input {

    private static final Scanner SCANNER = new Scanner(System.in);

    private Input() {
    }

    public static String getString() {
        String nextLine = SCANNER.nextLine();
        if (nextLine.equals("") || nextLine.equals(" ")) {
            throw new InvalidDataException("Invalid Input");
        }
        return nextLine;
    }

    public static Integer getInt() {
        return Integer.parseInt(getString());
    }

    public static Long getLong() {
        return Long.parseLong(getString());
    }

    public static Double getDouble() {
        return Double.parseDouble(getString());
    }
}
