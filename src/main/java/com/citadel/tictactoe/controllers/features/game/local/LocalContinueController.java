package com.citadel.tictactoe.controllers.features.game.local;

import com.citadel.tictactoe.controllers.features.game.ContinueController;
import com.citadel.tictactoe.controllers.features.game.OperationControllerVisitor;
import com.citadel.tictactoe.models.features.game.Game;

public class LocalContinueController extends LocalOperationController
    implements ContinueController {

    public LocalContinueController(Game game) {
        super(game);
    }

    @Override
    public void resume(boolean another) {
        if (another) {
            this.clear();
            this.initialize();
        } else {
            this.exit();
        }
    }

    @Override
    public void accept(OperationControllerVisitor visitor) {
        visitor.visit(this);
    }
}
