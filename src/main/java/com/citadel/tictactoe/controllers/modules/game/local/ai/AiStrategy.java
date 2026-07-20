package com.citadel.tictactoe.controllers.modules.game.local.ai;

import com.citadel.tictactoe.models.modules.game.Coordinate;
import com.citadel.tictactoe.models.modules.game.Game;

public interface AiStrategy {

    Coordinate chooseTarget(Game game);

    Coordinate chooseOrigin(Game game);

    Coordinate chooseMoveTarget(Game game, Coordinate origin);
}
