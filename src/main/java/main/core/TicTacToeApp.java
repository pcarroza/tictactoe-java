package main.core;

import main.controllers.features.game.local.logic.LocalLogic;
import main.core.commands.StartGameCommand;
import main.core.logics.game.GameLogic;
import main.views.console.ConsoleView;
import main.views.console.core.MenuView;

import java.util.List;

public class TicTacToeApp {

    public static void main(String[] args) {
        GameLogic game = new GameLogic(new LocalLogic(), new ConsoleView());
        new MenuView(List.of(new StartGameCommand(game))).run();
    }
}
