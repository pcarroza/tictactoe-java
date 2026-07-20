package com.citadel.tictactoe.controllers.modules.game.local;

import com.citadel.tictactoe.controllers.modules.game.OperationControllerVisitor;
import com.citadel.tictactoe.controllers.modules.game.RedoController;
import com.citadel.tictactoe.models.modules.game.Game;

public class LocalGameRedoController extends LocalGameOperationController implements RedoController {

    public LocalGameRedoController(Game game) {
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
