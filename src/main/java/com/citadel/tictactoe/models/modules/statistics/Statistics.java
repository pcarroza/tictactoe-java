package com.citadel.tictactoe.models.modules.statistics;

import com.citadel.tictactoe.models.modules.game.Player;
import com.citadel.tictactoe.models.persistence.repository.dao.StatisticsDao;
import com.citadel.tictactoe.models.persistence.service.StatisticsService;

public class Statistics {

    private final StatisticsService statisticsService;

    public Statistics(StatisticsDao statisticsDao) {
        this.statisticsService = new StatisticsService(statisticsDao);
    }

    public void recordWin(Player player) {
        assert player != Player.NONE;
        statisticsService.recordWin(player);
    }

    public int getWins(Player player) {
        return statisticsService.getWins(player);
    }

    public int getTotalGames() {
        return statisticsService.getTotalGames();
    }
}
