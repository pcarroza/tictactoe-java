package com.citadel.tictactoe.views.console.core.commands;

import com.citadel.tictactoe.models.features.game.GameHistoryRegistry;
import com.citadel.tictactoe.views.console.core.Feature;

public class ReplayGameCommand extends Command {

    private final Feature feature;

    public ReplayGameCommand(Feature feature) {
        super("Reproducir Partida");
        this.feature = feature;
    }

    @Override
    public boolean isAvailable() {
        return GameHistoryRegistry.getInstance().size() > 0;
    }

    @Override
    public void execute() {
        feature.run();
    }

}
