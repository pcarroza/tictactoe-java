package main.controllers.modules.game.local;

import main.controllers.modules.game.ContinueController;
import main.controllers.modules.game.OperationControllerVisitor;
import main.models.modules.game.Game;

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
    public void accept(OperationControllerVisitor operationControllerVisitor) {
        operationControllerVisitor.visit(this);
    }
}
