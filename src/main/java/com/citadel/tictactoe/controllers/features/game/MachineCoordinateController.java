package com.citadel.tictactoe.controllers.features.game;

import com.citadel.tictactoe.models.features.game.Coordinate;

public interface MachineCoordinateController extends CoordinateController {

    Coordinate getTarget(Coordinate origin);
}
