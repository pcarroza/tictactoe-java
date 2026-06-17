package main.controllers.features.game.local;

import main.controllers.features.game.CoordinateController;
import main.controllers.features.game.PlacementController;
import main.controllers.features.game.errors.ErrorGeneratorType;
import main.controllers.features.game.errors.ErrorReport;
import main.models.features.game.Coordinate;
import main.models.features.game.Game;

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
        return coordinateController;
    }
}
