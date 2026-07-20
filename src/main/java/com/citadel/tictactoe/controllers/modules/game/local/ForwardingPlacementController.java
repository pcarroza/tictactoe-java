package com.citadel.tictactoe.controllers.modules.game.local;

import com.citadel.tictactoe.controllers.modules.game.CoordinateController;
import com.citadel.tictactoe.controllers.modules.game.OperationControllerVisitor;
import com.citadel.tictactoe.controllers.modules.game.PlacementController;
import com.citadel.tictactoe.controllers.modules.game.PlacementControllerVisitor;
import com.citadel.tictactoe.controllers.modules.game.errors.ErrorReport;
import com.citadel.tictactoe.models.modules.game.Coordinate;
import com.citadel.tictactoe.models.modules.game.MoveHistory;
import com.citadel.tictactoe.models.modules.game.Player;

abstract class ForwardingPlacementController implements PlacementController {

    protected final PlacementController delegate;

    protected ForwardingPlacementController(PlacementController delegate) {
        assert delegate != null;
        this.delegate = delegate;
    }

    @Override
    public Player take() {
        return delegate.take();
    }

    @Override
    public void put(Coordinate target) {
        delegate.put(target);
    }

    @Override
    public boolean existTicTacToe() {
        return delegate.existTicTacToe();
    }

    @Override
    public CoordinateController getCoordinateController() {
        return delegate.getCoordinateController();
    }

    @Override
    public ErrorReport validateTarget(Coordinate target) {
        return delegate.validateTarget(target);
    }

    @Override
    public void changeTurn() {
        delegate.changeTurn();
    }

    @Override
    public void end() {
        delegate.end();
    }

    @Override
    public void save() {
        delegate.save();
    }

    @Override
    public void exit() {
        delegate.exit();
    }

    @Override
    public void undo() {
        delegate.undo();
    }

    @Override
    public boolean canUndo() {
        return delegate.canUndo();
    }

    @Override
    public void redo() {
        delegate.redo();
    }

    @Override
    public boolean canRedo() {
        return delegate.canRedo();
    }

    @Override
    public MoveHistory getMoveHistory() {
        return delegate.getMoveHistory();
    }

    @Override
    public Player getColor(Coordinate coordinate) {
        return delegate.getColor(coordinate);
    }

    @Override
    public void accept(PlacementControllerVisitor placementControllerVisitor) {
        delegate.accept(placementControllerVisitor);
    }

    @Override
    public void accept(OperationControllerVisitor operationControllerVisitor) {
        delegate.accept(operationControllerVisitor);
    }
}
