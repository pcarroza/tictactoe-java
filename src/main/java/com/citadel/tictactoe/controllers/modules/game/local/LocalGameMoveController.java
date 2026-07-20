package com.citadel.tictactoe.controllers.modules.game.local;

import com.citadel.tictactoe.controllers.modules.game.MoveController;
import com.citadel.tictactoe.controllers.modules.game.OperationControllerVisitor;
import com.citadel.tictactoe.controllers.modules.game.PlacementControllerVisitor;
import com.citadel.tictactoe.controllers.modules.game.errors.ErrorReport;
import com.citadel.tictactoe.controllers.modules.game.validation.CoordinateValidator;
import com.citadel.tictactoe.models.modules.game.Coordinate;
import com.citadel.tictactoe.models.modules.game.Game;

public class LocalGameMoveController extends LocalGamePlacementController implements MoveController {

    private final CoordinateValidator originValidator;

    private Coordinate origin;

    public LocalGameMoveController(
            Game game,
            LocalCoordinateController coordinateController,
            CoordinateValidator targetValidator,
            CoordinateValidator originValidator) {
        super(game, coordinateController, targetValidator);
        assert originValidator != null;
        this.originValidator = originValidator;
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
        return super.validateTarget(target, origin);
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
        return originValidator.validate(origin, null, getGame());
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
