package com.citadel.tictactoe.views.console.features.game;

import com.citadel.tictactoe.controllers.features.game.CoordinateController;
import com.citadel.tictactoe.controllers.features.game.RandomCoordinateController;
import com.citadel.tictactoe.controllers.features.game.UserCoordinateController;
import com.citadel.tictactoe.models.features.game.Coordinate;

public class MoveOriginCoordinateView extends PlacementCoordinateView {

    private Coordinate origin;

    public MoveOriginCoordinateView(CoordinateController coordinateController) {
        super(coordinateController);
    }

    @Override
    Coordinate getCoordinate() {
        origin = getCoordinateController().getOrigin();
        getCoordinateController().accept(this);
        return origin;
    }

    @Override
    public void visit(UserCoordinateController userCoordinateController) {
        CoordinateView.getInstance().read("De", origin);
    }

    @Override
    public void visit(RandomCoordinateController randomCoordinateController) {
        this.show("quita de", origin);
    }
}
