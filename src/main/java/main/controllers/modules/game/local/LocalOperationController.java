package main.controllers.modules.game.local;

import main.controllers.modules.game.OperationController;
import main.controllers.modules.game.OperationControllerVisitor;
import main.models.Game;

public abstract class LocalOperationController extends LocalController
    implements OperationController {

    protected LocalOperationController(Game game) {
        super(game);
    }

    public abstract void accept(OperationControllerVisitor visitor);
}
