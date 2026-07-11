package com.citadel.tictactoe.views.console.core.commands;

import com.citadel.tictactoe.views.console.core.Feature;

public class ReplayGameCommand extends Command {

    private final Feature feature;

    public ReplayGameCommand(Feature feature) {
        super("Reproducir Partida");
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
