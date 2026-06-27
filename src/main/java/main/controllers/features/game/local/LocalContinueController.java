package main.controllers.features.game.local;

import main.controllers.features.game.ContinueController;
import main.controllers.features.game.OperationControllerVisitor;
import main.models.features.game.Game;

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
