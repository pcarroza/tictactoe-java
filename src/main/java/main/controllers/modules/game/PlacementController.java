package main.controllers.modules.game;

import main.controllers.modules.game.errors.ErrorReport;
import main.models.Player;
import main.models.Coordinate;

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
