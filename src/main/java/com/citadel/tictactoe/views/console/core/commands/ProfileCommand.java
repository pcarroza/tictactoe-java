package com.citadel.tictactoe.views.console.core.commands;

import com.citadel.tictactoe.views.console.core.Feature;

public class ProfileCommand extends Command {

    private final Feature feature;

    public ProfileCommand(Feature feature) {
        super("Perfiles de Jugador");
        this.feature = feature;
    }

    @Override
    public void execute() {
        feature.run();
    }
}
