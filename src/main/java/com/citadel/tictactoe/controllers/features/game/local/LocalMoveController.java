package com.citadel.tictactoe.controllers.features.game.local;

import com.citadel.tictactoe.controllers.features.game.OperationControllerVisitor;
import com.citadel.tictactoe.controllers.features.game.PlacementControllerVisitor;
import com.citadel.tictactoe.controllers.features.game.errors.ErrorReport;
import com.citadel.tictactoe.controllers.features.game.MoveController;
import com.citadel.tictactoe.controllers.features.game.errors.ErrorGeneratorType;
import com.citadel.tictactoe.models.features.game.Coordinate;
import com.citadel.tictactoe.models.features.game.Game;

public class LocalMoveController extends LocalPlacementController implements MoveController {

    private Coordinate origin;

    LocalMoveController(Game game, LocalCoordinateController coordinateController) {
        super(game, coordinateController);
    }

    @Override
    public void put(Coordinate target) {
        assert target != null;
        assert origin != null;
        assert validateTarget(origin, target) == null;
        super.put(target);
        origin = null;
    }

    @Override
    public ErrorReport validateTarget(Coordinate origin, Coordinate target) {
        ErrorReport errorReport = super.validateTarget(target);
        if (errorReport != null) {
            return errorReport;
        }
        if (origin.equals(target)) {
            return ErrorGeneratorType.REPEATED_COORDINATE.getErrorReport(this.getGame());
        }
        return null;
    }

    @Override
    public void remove(Coordinate origin) {
        assert origin != null;
        assert validateOrigin(origin) == null;
        this.origin = origin;
        getGame().pushState();
        super.remove(origin);
    }

    @Override
    public ErrorReport validateOrigin(Coordinate origin) {
        assert origin != null;
        if (!this.isOccupiedByCurrentPlayer(origin)) {
            return ErrorGeneratorType.NOT_PROPERTY.getErrorReport(this.getGame());
        }
        return null;
    }

    @Override
    public boolean existTicTacToe() {
        return super.existTicTacToe();
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
