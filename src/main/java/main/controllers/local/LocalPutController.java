package main.controllers.local;

import main.controllers.OperationControllerVisitor;
import main.controllers.PlacementControllerVisitor;
import main.controllers.PutController;
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
