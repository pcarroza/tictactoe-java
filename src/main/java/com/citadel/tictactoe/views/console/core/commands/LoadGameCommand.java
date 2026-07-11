package com.citadel.tictactoe.views.console.core.commands;

import com.citadel.tictactoe.views.console.core.Feature;

public class LoadGameCommand extends Command {

    private final Feature feature;

    public LoadGameCommand(Feature feature) {
        super("Cargar Partida");
        this.feature = feature;
    }

    @Override
    public boolean isAvailable() {
        return feature.isAvailable();
    }

    @Override
    public void execute() {
        feature.run();
    }
}
