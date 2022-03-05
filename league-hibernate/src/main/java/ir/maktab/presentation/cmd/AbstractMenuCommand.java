package ir.maktab.presentation.cmd;

import ir.maktab.presentation.ui.Output;

public abstract class AbstractMenuCommand {

    protected final Output output;
    private final Integer selectNum;

    protected AbstractMenuCommand(Integer selectNum, Output output) {
        this.selectNum = selectNum;
        this.output = output;
    }

    public int select() {
        return selectNum;
    }

    public abstract void execute();
}
