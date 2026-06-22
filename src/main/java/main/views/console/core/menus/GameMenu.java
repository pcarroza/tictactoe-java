package main.views.console.core.menus;

import main.views.console.core.Feature;
import main.views.console.core.commands.StartGameCommand;

public class GameMenu extends Menu {

    @Override
    public void setCommand() {
        commands.add(new StartGameCommand());
    }
}
