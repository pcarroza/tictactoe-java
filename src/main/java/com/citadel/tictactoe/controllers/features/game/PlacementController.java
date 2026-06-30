package com.citadel.tictactoe.controllers.features.game;

import com.citadel.tictactoe.controllers.features.game.errors.ErrorReport;
import com.citadel.tictactoe.models.features.game.Coordinate;
import com.citadel.tictactoe.models.features.game.MoveHistory;
import com.citadel.tictactoe.models.features.game.Player;

public interface PlacementController extends OperationController, PresenterController {

    Player take();

    void put(Coordinate target);

    boolean existTicTacToe();

    CoordinateController getCoordinateController();

    ErrorReport validateTarget(Coordinate target);

    void changeTurn();

    void end();

    void save();

    void exit();

    void undo();

    boolean canUndo();

    void redo();

    boolean canRedo();

    MoveHistory getMoveHistory();

    void accept(PlacementControllerVisitor placementControllerVisitor);
}
