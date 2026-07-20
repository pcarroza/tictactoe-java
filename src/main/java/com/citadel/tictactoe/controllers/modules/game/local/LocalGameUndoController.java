package com.citadel.tictactoe.controllers.modules.game.local;

import com.citadel.tictactoe.controllers.modules.game.OperationControllerVisitor;
import com.citadel.tictactoe.controllers.modules.game.UndoController;
import com.citadel.tictactoe.models.modules.game.Game;

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
