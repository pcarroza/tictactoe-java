package main.controllers.local;

import main.controllers.OperationControllerVisitor;
import main.controllers.PlacementControllerVisitor;
import main.controllers.errors.ErrorReport;
import main.controllers.MoveController;
import main.controllers.errors.ErrorGeneratorType;
import main.models.Coordinate;
import main.models.Game;

public class LocalMoveController extends LocalPlacementController implements MoveController {

    private Coordinate origin;

    LocalMoveController(Game game, LocalCoordinateController coordinateController) {
        super(game, coordinateController);
    }

    @Override
    public void put(Coordinate target) {
        assert target != null;
        assert this.origin != null;
        assert this.validateTarget(this.origin, target) == null;
        super.put(target);
        this.origin = null;
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
        assert this.validateOrigin(origin) == null;
        this.origin = origin;
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
