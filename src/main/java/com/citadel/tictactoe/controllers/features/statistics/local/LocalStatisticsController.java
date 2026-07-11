package com.citadel.tictactoe.controllers.features.statistics.local;

import com.citadel.tictactoe.controllers.features.statistics.StatisticsController;
import com.citadel.tictactoe.models.features.game.Player;
import com.citadel.tictactoe.models.features.player.PlayerProfile;
import com.citadel.tictactoe.models.features.player.ProfileRegistry;
import com.citadel.tictactoe.models.features.statistics.Statistics;

public class LocalStatisticsController implements StatisticsController {

    private final Statistics statistics;

    private final ProfileRegistry profileRegistry;

    public LocalStatisticsController(Statistics statistics, ProfileRegistry profileRegistry) {
        this.statistics = statistics;
        this.profileRegistry = profileRegistry;
    }

    @Override
    public int getWins(Player player) {
        return statistics.getWins(player);
    }

    @Override
    public int getTotalGames() {
        return statistics.getTotalGames();
    }

    @Override
    public String getName(Player player) {
        return profileRegistry.findByToken(player)
                .map(PlayerProfile::name)
                .orElse(player == Player.XS ? "X" : "O");
    }
}
