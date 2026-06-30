package com.citadel.tictactoe.controllers.features.game.local;

import com.citadel.tictactoe.controllers.features.game.OperationController;
import com.citadel.tictactoe.controllers.features.game.OperationControllerVisitor;
import com.citadel.tictactoe.models.features.game.Game;

public abstract class LocalOperationController extends LocalController
    implements OperationController {

    protected LocalOperationController(Game game) {
        super(game);
    }

    public void undo() {
        getGame().undo();
    }

    public void redo() {
        getGame().redo();
    }

    public abstract void accept(OperationControllerVisitor visitor);
}
