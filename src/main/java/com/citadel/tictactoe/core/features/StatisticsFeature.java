package com.citadel.tictactoe.core.features;

import com.citadel.tictactoe.controllers.features.statistics.local.LocalStatisticsController;
import com.citadel.tictactoe.core.config.AppConfig;
import com.citadel.tictactoe.views.console.core.Feature;
import com.citadel.tictactoe.views.core.StatisticsView;

public class StatisticsFeature implements Feature {

    @Override
    public void run() {
        LocalStatisticsController controller = new LocalStatisticsController();
        StatisticsView view = AppConfig.viewType().createStatisticsView();
        view.interact(controller);
    }
}
