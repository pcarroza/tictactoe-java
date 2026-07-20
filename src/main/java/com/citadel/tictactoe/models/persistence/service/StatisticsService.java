package com.citadel.tictactoe.models.persistence.service;

import com.citadel.tictactoe.models.modules.game.Player;
import com.citadel.tictactoe.models.persistence.models.StatisticsDto;
import com.citadel.tictactoe.models.persistence.repository.dao.StatisticsDao;

import java.util.EnumMap;
import java.util.Map;

public class StatisticsService {

    private final StatisticsDao statisticsDao;

    public StatisticsService(StatisticsDao statisticsDao) {
        this.statisticsDao = statisticsDao;
    }

    public void recordWin(Player player) {
        Map<Player, Integer> wins = new EnumMap<>(currentWins());
        wins.merge(player, 1, Integer::sum);
        statisticsDao.save(new StatisticsDto(wins));
    }

    public int getWins(Player player) {
        return currentWins().getOrDefault(player, 0);
    }

    public int getTotalGames() {
        return currentWins().values().stream().mapToInt(Integer::intValue).sum();
    }

    private Map<Player, Integer> currentWins() {
        return statisticsDao.load().map(StatisticsDto::wins).orElseGet(() -> new EnumMap<>(Player.class));
    }
}
