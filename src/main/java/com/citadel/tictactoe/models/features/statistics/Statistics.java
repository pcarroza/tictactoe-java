package com.citadel.tictactoe.models.features.statistics;

import com.citadel.tictactoe.models.features.game.Player;
import com.citadel.tictactoe.models.persistence.repository.dao.StatisticsDao;
import com.citadel.tictactoe.models.persistence.service.StatisticsService;

public class Statistics {

    private final StatisticsService service;

    public Statistics(StatisticsDao statisticsDao) {
        this.service = new StatisticsService(statisticsDao);
    }

    public void recordWin(Player player) {
        assert player != Player.NONE;
        service.recordWin(player);
    }

    public int getWins(Player player) {
        return service.getWins(player);
    }

    public int getTotalGames() {
        return service.getTotalGames();
    }
}
