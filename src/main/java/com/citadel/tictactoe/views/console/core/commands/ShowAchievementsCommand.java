package com.citadel.tictactoe.views.console.core.commands;

import com.citadel.tictactoe.views.console.core.Feature;

public class ShowAchievementsCommand extends Command {

    private final Feature feature;

    public ShowAchievementsCommand(Feature feature) {
        super("Logros");
        this.feature = feature;
    }

    @Override
    public void execute() {
        feature.run();
    }
}
