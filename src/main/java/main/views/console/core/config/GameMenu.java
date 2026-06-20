package main.views.console.core.config;

import main.controllers.Logic;
import main.core.features.GameFeature;
import main.views.console.core.commands.Menu;
import main.views.console.core.commands.StartGameCommand;
import main.views.core.View;

public class GameMenu extends Menu {

    @Override
    public void setCommand() {
        commands.add(new StartGameCommand());
    }
}
