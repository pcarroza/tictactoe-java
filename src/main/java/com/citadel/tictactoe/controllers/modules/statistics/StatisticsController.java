package com.citadel.tictactoe.controllers.modules.statistics;

import com.citadel.tictactoe.models.modules.game.Player;

public interface StatisticsController {

    int getWins(Player player);

    int getTotalGames();

    String getName(Player player);
}
