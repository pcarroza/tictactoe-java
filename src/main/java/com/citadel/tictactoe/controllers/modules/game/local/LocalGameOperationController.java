package com.citadel.tictactoe.controllers.modules.game.local;

import com.citadel.tictactoe.controllers.modules.game.GameOperationController;
import com.citadel.tictactoe.controllers.modules.game.OperationControllerVisitor;
import com.citadel.tictactoe.models.modules.game.Game;

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
