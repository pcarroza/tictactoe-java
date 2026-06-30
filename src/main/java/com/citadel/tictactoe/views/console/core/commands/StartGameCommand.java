package com.citadel.tictactoe.views.console.core.commands;

import com.citadel.tictactoe.views.console.core.Feature;

public class StartGameCommand extends Command {

    private Feature feature;

    public StartGameCommand() {
        super("Iniciar Juego");
    }

    @Override
    public void set(Feature feature) {
        this.feature = feature;
    }

    @Override
    public void execute() {
        feature.run();
    }
}
