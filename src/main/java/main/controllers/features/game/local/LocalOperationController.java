package main.controllers.features.game.local;

import main.controllers.features.game.OperationController;
import main.controllers.features.game.OperationControllerVisitor;
import main.models.features.game.Game;

public abstract class LocalOperationController extends LocalController
    implements OperationController {

    protected LocalOperationController(Game game) {
        super(game);
    }

    public abstract void accept(OperationControllerVisitor visitor);
}
