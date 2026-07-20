package com.citadel.tictactoe.views.console.modules.game;

import com.citadel.tictactoe.controllers.modules.game.CoordinateController;
import com.citadel.tictactoe.controllers.modules.game.MachineCoordinateController;
import com.citadel.tictactoe.controllers.modules.game.UserCoordinateController;
import com.citadel.tictactoe.models.modules.game.Coordinate;
import com.citadel.tictactoe.shared.LimitedIntDialog;

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
        new CoordinateView(new LimitedIntDialog()).read("De", origin);
    }

    @Override
    public void visit(MachineCoordinateController machineCoordinateController) {
        this.show("quita de", origin);
    }
}
