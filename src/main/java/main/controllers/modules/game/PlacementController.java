package main.controllers.modules.game;

import main.controllers.modules.game.errors.ErrorReport;
import main.models.modules.game.Player;
import main.models.modules.game.Coordinate;

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
