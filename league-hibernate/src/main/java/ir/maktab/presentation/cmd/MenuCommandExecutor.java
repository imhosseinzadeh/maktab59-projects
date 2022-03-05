package ir.maktab.presentation.cmd;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuCommandExecutor {

    private final Map<Integer, AbstractMenuCommand> commandMap;

    public MenuCommandExecutor(List<AbstractMenuCommand> commandList) {
        Map<Integer, AbstractMenuCommand> temproryCommandMap = new HashMap<>();
        commandList.forEach(menuCommand -> temproryCommandMap.put(menuCommand.select(), menuCommand));

        this.commandMap = temproryCommandMap;
    }

    public void execute(Integer selected) {
        commandMap.get(selected).execute();
    }

    public int size() {
        return commandMap.size();
    }
}
