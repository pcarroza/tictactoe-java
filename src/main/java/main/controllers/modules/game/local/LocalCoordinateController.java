package main.controllers.modules.game.local;

import main.controllers.modules.game.CoordinateController;
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
