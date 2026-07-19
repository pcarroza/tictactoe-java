package com.citadel.tictactoe.core.features;

import com.citadel.tictactoe.controllers.features.statistics.local.LocalStatisticsController;
import com.citadel.tictactoe.core.config.AppConfig;
import com.citadel.tictactoe.models.features.player.ProfileRegistry;
import com.citadel.tictactoe.models.features.statistics.Statistics;
import com.citadel.tictactoe.views.console.core.Feature;
import com.citadel.tictactoe.views.core.StatisticsView;

public class StatisticsFeature implements Feature {

    private final Statistics statistics;

    private final ProfileRegistry profileRegistry;

    public StatisticsFeature(Statistics statistics, ProfileRegistry profileRegistry) {
        this.statistics = statistics;
        this.profileRegistry = profileRegistry;
    }

    @Override
    public void run() {
        LocalStatisticsController controller = new LocalStatisticsController(statistics, profileRegistry);
        StatisticsView statisticsView = AppConfig.viewType().createStatisticsView();
        statisticsView.interact(controller);
    }

    @Override
    public boolean isAvailable() {
        return statistics.getTotalGames() > 0;
    }
}
