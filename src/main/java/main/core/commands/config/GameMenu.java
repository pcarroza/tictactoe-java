package main.core.commands.config;

import main.controllers.features.game.local.logic.LocalLogic;
import main.core.commands.StartGameCommand;
import main.core.logics.game.GameLogic;
import main.views.console.ConsoleView;
import main.views.console.core.Command;
import main.views.console.core.Menu;

public class GameMenu extends Menu {

    @Override
    public void setCommand() {
        GameLogic game = new GameLogic();
        this.commands.add(new StartGameCommand(game));
    }
}
