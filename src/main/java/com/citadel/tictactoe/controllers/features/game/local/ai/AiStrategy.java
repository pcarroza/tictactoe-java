package com.citadel.tictactoe.controllers.features.game.local.ai;

import com.citadel.tictactoe.models.features.game.Coordinate;
import com.citadel.tictactoe.models.features.game.Game;

public interface AiStrategy {

    Coordinate chooseTarget(Game game);

    Coordinate chooseOrigin(Game game);

    Coordinate chooseMoveTarget(Game game, Coordinate origin);
}
