package com.citadel.tictactoe.controllers.modules.game;

import com.citadel.tictactoe.models.modules.game.Coordinate;

public interface MachineCoordinateController extends CoordinateController {

    Coordinate getTarget(Coordinate origin);
}
