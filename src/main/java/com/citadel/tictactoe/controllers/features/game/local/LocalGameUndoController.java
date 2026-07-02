package com.citadel.tictactoe.controllers.features.game.local;

import com.citadel.tictactoe.controllers.features.game.OperationControllerVisitor;
import com.citadel.tictactoe.controllers.features.game.UndoController;
import com.citadel.tictactoe.models.features.game.Game;

public class LocalGameUndoController extends LocalGameOperationController implements UndoController {

    public LocalGameUndoController(Game game) {
        super(game);
    }

    @Override
    public void undo() {
        getGame().revert();
        getGame().resume();
    }

    @Override
    public void cancel() {
        getGame().resume();
    }

    @Override
    public void accept(OperationControllerVisitor operationControllerVisitor) {
        operationControllerVisitor.visit(this);
    }
}
