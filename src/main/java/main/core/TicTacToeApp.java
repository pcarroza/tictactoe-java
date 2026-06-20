package main.core;

import java.time.Clock;

import main.controllers.features.game.local.logic.LocalLogic;
import main.core.features.GameFeature;
import main.views.console.core.commands.Menu;
import main.views.console.core.config.GameMenu;
import main.views.console.features.game.ConsoleView;

public class TicTacToeApp {

    public static void main(String[] args) {
        new GameMenu().execute(new GameFeature(new LocalLogic(), new ConsoleView()));
    }
}
