package main.controllers.features.game;

import main.controllers.features.game.errors.ErrorReport;
import main.models.features.game.Coordinate;

public interface MoveController extends PlacementController {

    void remove(Coordinate origin);

    ErrorReport validateOrigin(Coordinate origin);

    ErrorReport validateTarget(Coordinate origin, Coordinate target);
}
