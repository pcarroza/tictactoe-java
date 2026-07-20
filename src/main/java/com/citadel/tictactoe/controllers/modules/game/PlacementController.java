package com.citadel.tictactoe.controllers.modules.game;

import com.citadel.tictactoe.controllers.modules.game.errors.ErrorReport;
import com.citadel.tictactoe.models.modules.game.Coordinate;
import com.citadel.tictactoe.models.modules.game.MoveHistory;
import com.citadel.tictactoe.models.modules.game.Player;

public interface PlacementController extends GameOperationController, PresenterController {

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

    void redo();

    boolean canUndo();

    boolean canRedo();

    MoveHistory getMoveHistory();

    void accept(PlacementControllerVisitor placementControllerVisitor);
}
