package com.citadel.tictactoe.controllers.features.game.local;

import com.citadel.tictactoe.controllers.features.game.OperationControllerVisitor;
import com.citadel.tictactoe.controllers.features.game.PlacementControllerVisitor;
import com.citadel.tictactoe.controllers.features.game.PutController;
import com.citadel.tictactoe.models.features.game.Coordinate;
import com.citadel.tictactoe.models.features.game.Game;

public class LocalPutController extends LocalPlacementController
    implements PutController {

    LocalPutController(Game game, LocalCoordinateController localCoordinateController) {
        super(game, localCoordinateController);
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
