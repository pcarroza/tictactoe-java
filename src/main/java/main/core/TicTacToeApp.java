package main.core;

import main.controllers.features.game.local.logic.LocalLogic;
import main.core.commands.StartGameCommand;
import main.core.commands.config.GameMenu;
import main.core.logics.game.GameLogic;
import main.views.console.ConsoleView;
import main.views.console.core.Menu;

public class TicTacToeApp {

    public static void main(String[] args) {
        new GameMenu().run();
    }
}
