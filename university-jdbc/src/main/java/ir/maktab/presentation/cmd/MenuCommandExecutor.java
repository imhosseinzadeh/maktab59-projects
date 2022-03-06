package ir.maktab.presentation.cmd;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuCommandExecutor {
    private final Map<Integer, MenuCommand> menuCommandMap;

    public MenuCommandExecutor(List<MenuCommand> commands) {
        Map<Integer, MenuCommand> commandMap = new HashMap<>();
        for (MenuCommand command : commands) {
            commandMap.put(command.select(), command);
        }
        this.menuCommandMap = commandMap;
    }

    public void execute(Integer selected) {
        menuCommandMap.get(selected).execute();
    }

}
