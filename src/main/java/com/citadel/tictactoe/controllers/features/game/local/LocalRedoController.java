package com.citadel.tictactoe.controllers.features.game.local;

import com.citadel.tictactoe.controllers.features.game.OperationControllerVisitor;
import com.citadel.tictactoe.controllers.features.game.RedoController;
import com.citadel.tictactoe.models.features.game.Game;

public class LocalRedoController extends LocalOperationController implements RedoController {

    LocalRedoController(Game game) {
        super(game);
    }

    @Override
    public void redo() {
        getGame().reapply();
        getGame().resume();
    }

    @Override
    public void cancel() {
        getGame().resume();
    }

    @Override
    public void accept(OperationControllerVisitor visitor) {
        visitor.visit(this);
    }
}
