package com.citadel.tictactoe.controllers.modules.statistics.local;

import com.citadel.tictactoe.controllers.modules.statistics.StatisticsController;
import com.citadel.tictactoe.models.modules.game.Player;
import com.citadel.tictactoe.models.modules.player.PlayerProfile;
import com.citadel.tictactoe.models.modules.player.ProfileRegistry;
import com.citadel.tictactoe.models.modules.statistics.Statistics;

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
        return profileRegistry.findBy(player).map(PlayerProfile::name).orElse(player == Player.XS ? "X" : "O");
    }
}
