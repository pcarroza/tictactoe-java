package main.controllers.modules.game.local;

import main.controllers.modules.game.CoordinateController;
import main.controllers.modules.game.PlacementController;
import main.controllers.modules.game.errors.ErrorGeneratorType;
import main.controllers.modules.game.errors.ErrorReport;
import main.models.modules.game.Coordinate;
import main.models.modules.game.Game;

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
