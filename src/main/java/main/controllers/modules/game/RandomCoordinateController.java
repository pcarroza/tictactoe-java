package main.controllers.modules.game;

import main.models.Coordinate;

public interface RandomCoordinateController extends  CoordinateController {

    Coordinate getTarget(Coordinate origin);
}
