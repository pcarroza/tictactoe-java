package main.controllers.features.game.local;

import main.controllers.features.game.OperationControllerVisitor;
import main.controllers.features.game.PlacementControllerVisitor;
import main.controllers.features.game.PutController;
import main.models.features.game.Coordinate;
import main.models.features.game.Game;

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
