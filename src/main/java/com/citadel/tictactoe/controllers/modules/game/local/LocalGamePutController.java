package com.citadel.tictactoe.controllers.modules.game.local;

import com.citadel.tictactoe.controllers.modules.game.OperationControllerVisitor;
import com.citadel.tictactoe.controllers.modules.game.PlacementControllerVisitor;
import com.citadel.tictactoe.controllers.modules.game.PutController;
import com.citadel.tictactoe.controllers.modules.game.validation.CoordinateValidator;
import com.citadel.tictactoe.models.modules.game.Coordinate;
import com.citadel.tictactoe.models.modules.game.Game;

public class LocalGamePutController extends LocalGamePlacementController
    implements PutController {

    public LocalGamePutController(Game game, LocalCoordinateController localCoordinateController,
            CoordinateValidator targetValidator) {
        super(game, localCoordinateController, targetValidator);
    }

    @Override
    public void put(Coordinate target) {
        assert super.validateTarget(target) == null;
        getGame().pushState();
        super.put(target);
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
