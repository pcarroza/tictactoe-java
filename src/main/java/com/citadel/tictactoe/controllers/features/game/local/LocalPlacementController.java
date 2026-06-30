package com.citadel.tictactoe.controllers.features.game.local;

import com.citadel.tictactoe.controllers.features.game.CoordinateController;
import com.citadel.tictactoe.controllers.features.game.PlacementController;
import com.citadel.tictactoe.controllers.features.game.errors.ErrorGeneratorType;
import com.citadel.tictactoe.controllers.features.game.errors.ErrorReport;
import com.citadel.tictactoe.models.features.game.Coordinate;
import com.citadel.tictactoe.models.features.game.Game;

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

    @Override
    public boolean canUndo() {
        return getGame().canRevert();
    }

    @Override
    public boolean canRedo() {
        return getGame().canReapply();
    }
}
