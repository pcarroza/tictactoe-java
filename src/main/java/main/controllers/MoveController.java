package main.controllers;

import main.controllers.errors.ErrorReport;
import main.models.Coordinate;

public interface MoveController extends PlacementController {

    void remove(Coordinate origin);

    ErrorReport validateOrigin(Coordinate origin);

    ErrorReport validateTarget(Coordinate origin, Coordinate target);
}
