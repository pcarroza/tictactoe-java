package main.controllers.features.game;

import main.models.features.game.Coordinate;

public interface CoordinateController {

    Coordinate getOrigin();

    Coordinate getTarget();

    void accept(CoordinateControllerVisitor coordinateControllerVisitor);
}
