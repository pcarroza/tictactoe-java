package main.controllers.modules.game;

import main.models.modules.game.Coordinate;

public interface RandomCoordinateController extends  CoordinateController {

    Coordinate getTarget(Coordinate origin);
}
