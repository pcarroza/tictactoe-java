package main.controllers.modules.game.local;

import main.controllers.modules.game.OperationControllerVisitor;
import main.controllers.modules.game.PlacementControllerVisitor;
import main.controllers.modules.game.PutController;
import main.models.Coordinate;
import main.models.Game;

public class LocalPutController extends LocalPlacementController
    implements PutController {

    LocalPutController(Game game, LocalCoordinateController localCoordinateController) {
        super(game, localCoordinateController);
    }

    @Override
    public void put(Coordinate target) {
        assert super.validateTarget(target) == null;
        super.put(target);
    }

    @Override
    public void accept(PlacementControllerVisitor placementControllerVisitor) {
        placementControllerVisitor.visit(this);
    }

    @Override
    public void accept(OperationControllerVisitor operationControllerVisitor) {
        operationControllerVisitor.visit(this);
    }
}
