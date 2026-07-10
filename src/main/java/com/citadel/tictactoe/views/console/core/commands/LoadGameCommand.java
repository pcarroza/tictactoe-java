package com.citadel.tictactoe.views.console.core.commands;

import com.citadel.tictactoe.models.features.game.GameRegistry;
import com.citadel.tictactoe.views.console.core.Feature;

public class LoadGameCommand extends Command {

    private final Feature feature;

    public LoadGameCommand(Feature feature) {
        super("Cargar Partida");
        this.feature = feature;
    }

    @Override
    public boolean isAvailable() {
        return GameRegistry.getInstance().size() > 0;
    }

    @Override
    public void execute() {
        feature.run();
    }
}
