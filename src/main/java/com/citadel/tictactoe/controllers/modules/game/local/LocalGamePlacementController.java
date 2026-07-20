package com.citadel.tictactoe.controllers.modules.game.local;

import com.citadel.tictactoe.controllers.modules.game.CoordinateController;
import com.citadel.tictactoe.controllers.modules.game.PlacementController;
import com.citadel.tictactoe.controllers.modules.game.errors.ErrorReport;
import com.citadel.tictactoe.controllers.modules.game.validation.CoordinateValidator;
import com.citadel.tictactoe.events.EventManager;
import com.citadel.tictactoe.models.modules.game.Coordinate;
import com.citadel.tictactoe.models.modules.game.Game;
import com.citadel.tictactoe.models.modules.game.events.GameEndedEvent;

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
