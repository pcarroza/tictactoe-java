package com.citadel.tictactoe.controllers.features.game.local;

import com.citadel.tictactoe.controllers.features.game.GameOperationController;
import com.citadel.tictactoe.controllers.features.game.OperationControllerVisitor;
import com.citadel.tictactoe.models.features.game.Game;

public abstract class LocalGameOperationController extends LocalController
    implements GameOperationController {

    protected LocalGameOperationController(Game game) {
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
