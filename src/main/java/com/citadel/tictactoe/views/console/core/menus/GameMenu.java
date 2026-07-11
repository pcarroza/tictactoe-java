package com.citadel.tictactoe.views.console.core.menus;

import com.citadel.tictactoe.views.console.core.ConsoleContext;
import com.citadel.tictactoe.views.console.core.commands.StartGameCommand;

public class GameMenu extends Menu {

    public GameMenu(ConsoleContext consoleContext) {
        super("Juego", consoleContext);
        commands.add(new StartGameCommand());
    }
}
