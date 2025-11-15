package main.controllers.modules.game;

import main.models.Coordinate;

public interface CoordinateController {

    Coordinate getOrigin();

    Coordinate getTarget();

    void accept(CoordinateControllerVisitor coordinateControllerVisitor);
}
