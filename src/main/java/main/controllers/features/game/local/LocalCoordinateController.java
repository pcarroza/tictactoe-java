package main.controllers.features.game.local;

import main.controllers.features.game.CoordinateController;
import main.models.features.game.Coordinate;
import main.models.features.game.Game;

public abstract class LocalCoordinateController extends LocalController
        implements CoordinateController {

    protected LocalCoordinateController(Game game) {
        super(game);
    }

    public abstract Coordinate getOrigin();

    public abstract Coordinate getTarget();
}
