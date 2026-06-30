package com.citadel.tictactoe.views.console.core.menus;

import com.citadel.tictactoe.views.console.core.commands.StartGameCommand;

public class GameMenu extends Menu {

    public GameMenu() {
        super("Juego");
    }

    @Override
    public void setCommand() {
        commands.add(new StartGameCommand());
    }
}
