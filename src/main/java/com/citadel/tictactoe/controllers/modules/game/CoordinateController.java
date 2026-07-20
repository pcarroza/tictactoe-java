package com.citadel.tictactoe.controllers.modules.game;

import com.citadel.tictactoe.models.modules.game.Coordinate;

public interface CoordinateController {

    Coordinate getOrigin();

    Coordinate getTarget();

    void accept(CoordinateControllerVisitor coordinateControllerVisitor);
}
