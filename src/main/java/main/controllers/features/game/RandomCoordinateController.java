package main.controllers.features.game;

import main.models.features.game.Coordinate;

public interface RandomCoordinateController extends  CoordinateController {

    Coordinate getTarget(Coordinate origin);
}
