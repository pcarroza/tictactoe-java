package com.citadel.tictactoe.views.console.core.commands;

import com.citadel.tictactoe.models.features.game.GameHistoryRegistry;
import com.citadel.tictactoe.views.console.core.Feature;

public class ReplayGameCommand extends Command {

    private Feature feature;

    public ReplayGameCommand() {
        super("Reproducir Partida");
    }

    public void setReplay(Feature feature) {
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
