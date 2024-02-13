package main.controllers;

import main.controllers.errors.ErrorReport;
import main.models.Color;
import main.models.Coordinate;

public interface PlacementController extends OperationController, PresenterController {

    Color take();

    void put(Coordinate target);

    boolean existTicTacToe();

    CoordinateController getCoordinateController();

    ErrorReport validateTarget(Coordinate target);

    void switchTurn();

    void end();

    void accept(PlacementControllerVisitor placementControllerVisitor);
}
