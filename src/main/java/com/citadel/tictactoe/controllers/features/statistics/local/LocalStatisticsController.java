package com.citadel.tictactoe.controllers.features.statistics.local;

import com.citadel.tictactoe.controllers.features.statistics.StatisticsController;
import com.citadel.tictactoe.models.features.game.Player;
import com.citadel.tictactoe.models.features.statistics.Statistics;

public class LocalStatisticsController implements StatisticsController {

    @Override
    public int getWins(Player player) {
        return Statistics.getInstance().getWins(player);
    }

    @Override
    public int getTotalGames() {
        return Statistics.getInstance().getTotalGames();
    }
}
