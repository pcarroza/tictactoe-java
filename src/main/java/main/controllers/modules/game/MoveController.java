package main.controllers.modules.game;

import main.controllers.modules.game.errors.ErrorReport;
import main.models.modules.game.Coordinate;

public interface MoveController extends PlacementController {

    void remove(Coordinate origin);

    ErrorReport validateOrigin(Coordinate origin);

    ErrorReport validateTarget(Coordinate origin, Coordinate target);
}
