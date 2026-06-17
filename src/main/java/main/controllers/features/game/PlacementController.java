package main.controllers.features.game;

import main.controllers.features.game.errors.ErrorReport;
import main.models.features.game.Player;
import main.models.features.game.Coordinate;

public interface PlacementController extends OperationController, PresenterController {

    Player take();

    void put(Coordinate target);

    boolean existTicTacToe();

    CoordinateController getCoordinateController();

    ErrorReport validateTarget(Coordinate target);

    void changeTurn();

    void end();

    void accept(PlacementControllerVisitor placementControllerVisitor);
}
