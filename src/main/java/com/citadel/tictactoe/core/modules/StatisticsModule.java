package com.citadel.tictactoe.core.modules;

import com.citadel.tictactoe.controllers.modules.statistics.local.LocalStatisticsController;
import com.citadel.tictactoe.core.config.AppConfig;
import com.citadel.tictactoe.models.modules.player.ProfileRegistry;
import com.citadel.tictactoe.models.modules.statistics.Statistics;
import com.citadel.tictactoe.views.console.core.Module;
import com.citadel.tictactoe.views.core.StatisticsView;

public class StatisticsModule implements Module {

    private final Statistics statistics;

    private final ProfileRegistry profileRegistry;

    public StatisticsModule(Statistics statistics, ProfileRegistry profileRegistry) {
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
