package com.citadel.tictactoe.views.console.core.commands;

import com.citadel.tictactoe.views.console.core.Feature;

public class LoadGameCommand extends Command {

    private Feature feature;

    public LoadGameCommand() {
        super("Cargar Partida");
    }

    public void setLoadGame(Feature feature) {
        this.feature = feature;
    }

    @Override
    public void execute() {
        feature.run();
    }
}
