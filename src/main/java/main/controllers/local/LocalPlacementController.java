package main.controllers.local;

import main.controllers.CoordinateController;
import main.controllers.OperationControllerVisitor;
import main.controllers.PlacementController;
import main.controllers.PlacementControllerVisitor;
import main.controllers.errors.ErrorGeneratorType;
import main.controllers.errors.ErrorReport;
import main.models.Coordinate;
import main.models.Game;

public abstract class LocalPlacementController extends LocalOperationController
    implements PlacementController {

    private final LocalCoordinateController coordinateController;

    public LocalPlacementController(Game game, LocalCoordinateController coordinateController) {
        super(game);
        assert coordinateController != null;
        this.coordinateController = coordinateController;
    }

    @Override
    public ErrorReport validateTarget(Coordinate target) {
        if (!this.isEmpty(target)) {
            return ErrorGeneratorType.NOT_EMPTY.getErrorReport(this.getGame());
        }
        return null;
    }

    @Override
    public CoordinateController getCoordinateController() {
        return this.coordinateController;
    }
}
