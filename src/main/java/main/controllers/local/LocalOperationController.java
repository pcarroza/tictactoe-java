package main.controllers.local;

import main.controllers.OperationController;
import main.controllers.OperationControllerVisitor;
import main.models.Game;

public abstract class LocalOperationController extends LocalController
    implements OperationController {

    protected LocalOperationController(Game game) {
        super(game);
    }

    public abstract void accept(OperationControllerVisitor visitor);
}
