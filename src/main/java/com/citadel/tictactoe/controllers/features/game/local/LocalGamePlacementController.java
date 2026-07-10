package com.citadel.tictactoe.controllers.features.game.local;

import com.citadel.tictactoe.controllers.features.game.CoordinateController;
import com.citadel.tictactoe.controllers.features.game.PlacementController;
import com.citadel.tictactoe.controllers.features.game.errors.ErrorReport;
import com.citadel.tictactoe.controllers.features.game.validation.CoordinateValidator;
import com.citadel.tictactoe.events.EventManager;
import com.citadel.tictactoe.models.features.game.Coordinate;
import com.citadel.tictactoe.models.features.game.Game;
import com.citadel.tictactoe.models.features.game.events.GameEndedEvent;

public abstract class LocalGamePlacementController extends LocalGameOperationController implements PlacementController {

    private final LocalCoordinateController coordinateController;

    private final CoordinateValidator targetValidator;

    public LocalGamePlacementController(Game game, LocalCoordinateController coordinateController, CoordinateValidator targetValidator) {
        super(game);
        assert coordinateController != null;
        assert targetValidator != null;
        this.coordinateController = coordinateController;
        this.targetValidator = targetValidator;
    }

    @Override
    public ErrorReport validateTarget(Coordinate target) {
        return validateTarget(target, null);
    }

    protected ErrorReport validateTarget(Coordinate target, Coordinate origin) {
        return targetValidator.validate(target, origin, getGame());
    }

    @Override
    public CoordinateController getCoordinateController() {
        return coordinateController;
    }

    @Override
    public void end() {
        EventManager.getInstance().publish(new GameEndedEvent(take(), getGame().getMoveHistory().copy()));
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
