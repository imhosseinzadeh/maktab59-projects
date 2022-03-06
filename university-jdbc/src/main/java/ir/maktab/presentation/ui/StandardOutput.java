package ir.maktab.presentation.ui;

public class StandardOutput implements Output {

    @Override
    public void print(String output) {
        System.out.print(output);
    }

    @Override
    public void println(String output) {
        System.out.println(output);
    }

    @Override
    public void close(String output) {
        System.out.println(output);
    }
}
