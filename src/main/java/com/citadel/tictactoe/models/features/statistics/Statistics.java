package com.citadel.tictactoe.models.features.statistics;

import com.citadel.tictactoe.models.features.game.Player;

import java.util.EnumMap;
import java.util.Map;

public class Statistics {

    private static final Statistics instance = new Statistics();

    private final Map<Player, Integer> wins;

    private Statistics() {
        this.wins = new EnumMap<>(Player.class);
        this.wins.put(Player.XS, 0);
        this.wins.put(Player.OS, 0);
    }

    public static Statistics getInstance() {
        return instance;
    }

    public void recordWin(Player player) {
        assert player != Player.NONE;
        wins.merge(player, 1, Integer::sum);
    }

    public int getWins(Player player) {
        return wins.getOrDefault(player, 0);
    }

    public int getTotalGames() {
        return wins.values().stream().mapToInt(Integer::intValue).sum();
    }
}
