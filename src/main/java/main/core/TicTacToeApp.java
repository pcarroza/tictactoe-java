package main.core;

import main.controllers.features.game.local.logic.LocalLogic;
import main.core.commands.StartGameCommand;
import main.core.logics.game.GameLogic;
import main.views.console.ConsoleView;
import main.views.console.core.Menu;

public class TicTacToeApp {

    public static void main(String[] args) {
        GameLogic game = new GameLogic(new LocalLogic(), new ConsoleView());
        new Menu(new StartGameCommand(game)).run();
    }
}
