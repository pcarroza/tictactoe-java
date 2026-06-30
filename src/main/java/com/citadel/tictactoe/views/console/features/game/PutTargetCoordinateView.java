package com.citadel.tictactoe.views.console.features.game;

import com.citadel.tictactoe.controllers.features.game.CoordinateController;
import com.citadel.tictactoe.controllers.features.game.RandomCoordinateController;
import com.citadel.tictactoe.controllers.features.game.UserCoordinateController;
import com.citadel.tictactoe.models.features.game.Coordinate;

public class PutTargetCoordinateView extends PlacementCoordinateView {

    private Coordinate target;

    public PutTargetCoordinateView(CoordinateController coordinateController) {
        super(coordinateController);
    }

    @Override
    Coordinate getCoordinate() {
        target = getCoordinateController().getTarget();
        getCoordinateController().accept(this);
        return target;
    }

    @Override
    public void visit(UserCoordinateController userCoordinateController) {
        CoordinateView.getInstance().read("En ", target);
    }

    @Override
    public void visit(RandomCoordinateController randomCoordinateController) {
        super.show("pone en", target);
    }
}
