package com.citadel.tictactoe.models.features.statistics;

import com.citadel.tictactoe.models.features.game.Player;
import com.citadel.tictactoe.models.persistence.Persistence;
import com.citadel.tictactoe.models.persistence.service.StatisticsService;

public class Statistics {

    private static final Statistics instance = new Statistics();

    private final StatisticsService service;

    private Statistics() {
        this.service = new StatisticsService(Persistence.daoFactory().createStatisticsDao());
    }

    public static Statistics getInstance() {
        return instance;
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
