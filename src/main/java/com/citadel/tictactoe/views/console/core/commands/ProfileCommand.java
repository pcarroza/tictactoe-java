package com.citadel.tictactoe.views.console.core.commands;

import com.citadel.tictactoe.views.console.core.Feature;

public class ProfileCommand extends Command {

    private Feature feature;

    public ProfileCommand() {
        super("Perfiles de Jugador");
    }

    public void setProfile(Feature feature) {
        this.feature = feature;
    }

    @Override
    public void execute() {
        feature.run();
    }
}
