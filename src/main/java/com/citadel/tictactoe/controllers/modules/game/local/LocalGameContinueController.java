package com.citadel.tictactoe.controllers.modules.game.local;

import com.citadel.tictactoe.controllers.modules.game.ContinueController;
import com.citadel.tictactoe.controllers.modules.game.OperationControllerVisitor;
import com.citadel.tictactoe.models.modules.game.Game;

public class LocalGameContinueController extends LocalGameOperationController
    implements ContinueController {

    public LocalGameContinueController(Game game) {
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
