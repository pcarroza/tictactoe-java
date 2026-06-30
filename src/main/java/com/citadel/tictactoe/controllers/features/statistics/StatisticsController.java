package com.citadel.tictactoe.controllers.features.statistics;

import com.citadel.tictactoe.models.features.game.Player;

public interface StatisticsController {

    int getWins(Player player);

    int getTotalGames();
}
