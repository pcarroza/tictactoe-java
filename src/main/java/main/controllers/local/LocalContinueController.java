package main.controllers.local;

import main.controllers.ContinueController;
import main.controllers.OperationControllerVisitor;
import main.models.Game;

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
