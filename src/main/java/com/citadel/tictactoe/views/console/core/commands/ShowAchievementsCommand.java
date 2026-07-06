package com.citadel.tictactoe.views.console.core.commands;

import com.citadel.tictactoe.views.console.core.Feature;

public class ShowAchievementsCommand extends Command {

    private Feature feature;

    public ShowAchievementsCommand() {
        super("Logros");
    }

    public void setShowAchievements(Feature feature) {
        this.feature = feature;
    }

    @Override
    public void execute() {
        feature.run();
    }
}
