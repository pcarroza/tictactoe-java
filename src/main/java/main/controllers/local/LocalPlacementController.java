package main.controllers.local;

import main.controllers.CoordinateController;
import main.controllers.PlacementController;
import main.controllers.errors.ErrorGeneratorType;
import main.controllers.errors.ErrorReport;
import main.models.Coordinate;
import main.models.Game;

public abstract class LocalPlacementController extends LocalOperationController
    implements PlacementController {

    private final LocalCoordinateController localCoordinateController;

    public LocalPlacementController(Game game, LocalCoordinateController localCoordinateController) {
        super(game);
        assert localCoordinateController != null;
        this.localCoordinateController = localCoordinateController;
    }

    @Override
    public ErrorReport validateTarget(Coordinate target) {
        if (!this.isEmpty(target)) {
            return ErrorGeneratorType.NOT_EMPTY.getErrorReport(this.getGame());
        }
        return null;
    }

    public CoordinateController getCoordinateController() {
        return localCoordinateController;
    }
}
