package com.citadel.tictactoe.controllers.features.game;

import com.citadel.tictactoe.controllers.features.game.errors.ErrorReport;
import com.citadel.tictactoe.models.features.game.Player;
import com.citadel.tictactoe.models.features.game.Coordinate;

public interface PlacementController extends OperationController, PresenterController {

    Player take();

    void put(Coordinate target);

    boolean existTicTacToe();

    CoordinateController getCoordinateController();

    ErrorReport validateTarget(Coordinate target);

    void changeTurn();

    void end();

    void accept(PlacementControllerVisitor placementControllerVisitor);

    void save();

    void exit();
}
