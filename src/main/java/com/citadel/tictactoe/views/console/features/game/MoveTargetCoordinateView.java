package com.citadel.tictactoe.views.console.features.game;

import com.citadel.tictactoe.controllers.features.game.RandomCoordinateController;
import com.citadel.tictactoe.controllers.features.game.UserCoordinateController;
import com.citadel.tictactoe.controllers.features.game.CoordinateController;
import com.citadel.tictactoe.models.features.game.Coordinate;

public class MoveTargetCoordinateView extends PlacementCoordinateView {

    private final Coordinate origin;

    private Coordinate target;

    public MoveTargetCoordinateView(CoordinateController coordinateController, Coordinate origin) {
        super(coordinateController);
        assert origin != null;
        this.origin = origin;
    }

    @Override
    Coordinate getCoordinate() {
        getCoordinateController().accept(this);
        return target;
    }

    @Override
    public void visit(UserCoordinateController userCoordinateController) {
        target = userCoordinateController.getTarget();
        CoordinateView.getInstance().read("A", target);
    }

    @Override
    public void visit(RandomCoordinateController randomCoordinateController) {
        target = randomCoordinateController.getTarget(origin);
        super.show("pone en: ", target);
    }
}
