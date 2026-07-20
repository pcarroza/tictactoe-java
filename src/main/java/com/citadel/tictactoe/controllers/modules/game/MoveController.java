package com.citadel.tictactoe.controllers.modules.game;

import com.citadel.tictactoe.controllers.modules.game.errors.ErrorReport;
import com.citadel.tictactoe.models.modules.game.Coordinate;

public interface MoveController extends PlacementController {

    void remove(Coordinate origin);

    ErrorReport validateOrigin(Coordinate origin);

    ErrorReport validateTarget(Coordinate origin, Coordinate target);
}
