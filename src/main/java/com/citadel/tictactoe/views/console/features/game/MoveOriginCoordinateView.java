package com.citadel.tictactoe.views.console.features.game;

import com.citadel.tictactoe.controllers.features.game.CoordinateController;
import com.citadel.tictactoe.controllers.features.game.MachineCoordinateController;
import com.citadel.tictactoe.controllers.features.game.UserCoordinateController;
import com.citadel.tictactoe.models.features.game.Coordinate;
import com.citadel.tictactoe.views.console.core.ConsoleContext;

public class MoveOriginCoordinateView extends PlacementCoordinateView {

    private Coordinate origin;

    public MoveOriginCoordinateView(CoordinateController coordinateController, ConsoleContext consoleContext) {
        super(coordinateController, consoleContext);
    }

    @Override
    Coordinate getCoordinate() {
        origin = getCoordinateController().getOrigin();
        getCoordinateController().accept(this);
        return origin;
    }

    @Override
    public void visit(UserCoordinateController userCoordinateController) {
        getConsoleContext().coordinateView().read("De", origin);
    }

    @Override
    public void visit(MachineCoordinateController machineCoordinateController) {
        this.show("quita de", origin);
    }
}
