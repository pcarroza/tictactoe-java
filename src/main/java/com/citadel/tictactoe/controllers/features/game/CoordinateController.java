package com.citadel.tictactoe.controllers.features.game;

import com.citadel.tictactoe.models.features.game.Coordinate;

public interface CoordinateController {

    Coordinate getOrigin();

    Coordinate getTarget();

    void accept(CoordinateControllerVisitor coordinateControllerVisitor);
}
