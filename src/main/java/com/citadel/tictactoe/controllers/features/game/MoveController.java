package com.citadel.tictactoe.controllers.features.game;

import com.citadel.tictactoe.controllers.features.game.errors.ErrorReport;
import com.citadel.tictactoe.models.features.game.Coordinate;

public interface MoveController extends PlacementController {

    void remove(Coordinate origin);

    ErrorReport validateOrigin(Coordinate origin);

    ErrorReport validateTarget(Coordinate origin, Coordinate target);
}
