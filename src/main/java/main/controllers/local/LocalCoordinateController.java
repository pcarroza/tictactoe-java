package main.controllers.local;

import main.controllers.CoordinateController;
import main.models.Coordinate;
import main.models.Game;

public abstract class LocalCoordinateController extends LocalController
        implements CoordinateController {

    protected LocalCoordinateController(Game game) {
        super(game);
    }

    public abstract Coordinate getOrigin();

    public abstract Coordinate getTarget();
}
