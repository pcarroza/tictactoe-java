package com.citadel.tictactoe.views.console.core.commands;

import com.citadel.tictactoe.models.features.statistics.Statistics;
import com.citadel.tictactoe.views.console.core.Feature;

public class ShowStatsCommand extends Command {

    private final Feature feature;

    public ShowStatsCommand(Feature feature) {
        super("Estadísticas");
        this.feature = feature;
    }

    @Override
    public boolean isAvailable() {
        return Statistics.getInstance().getTotalGames() > 0;
    }

    @Override
    public void execute() {
        feature.run();
    }
}
