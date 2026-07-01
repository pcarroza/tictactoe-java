package com.citadel.tictactoe.controllers.features.game.local;

import com.citadel.tictactoe.controllers.features.game.CoordinateController;
import com.citadel.tictactoe.controllers.features.game.PlacementController;
import com.citadel.tictactoe.controllers.features.game.errors.ErrorGeneratorType;
import com.citadel.tictactoe.controllers.features.game.errors.ErrorReport;
import com.citadel.tictactoe.models.features.game.Coordinate;
import com.citadel.tictactoe.models.features.game.Game;
import com.citadel.tictactoe.models.features.game.GameHistoryRegistry;
import com.citadel.tictactoe.models.features.statistics.Statistics;

public abstract class LocalGamePlacementController extends LocalGameOperationController
    implements PlacementController {

    private final LocalCoordinateController coordinateController;

    public LocalGamePlacementController(Game game, LocalCoordinateController coordinateController) {
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
    public void end() {
        Statistics.getInstance().recordWin(take());
        GameHistoryRegistry.getInstance().record(getGame().getMoveHistory().copy());
        super.end();
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
