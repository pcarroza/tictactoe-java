package com.citadel.tictactoe.views.console.features.game;

import com.citadel.tictactoe.controllers.features.game.CoordinateController;
import com.citadel.tictactoe.controllers.features.game.MachineCoordinateController;
import com.citadel.tictactoe.controllers.features.game.UserCoordinateController;
import com.citadel.tictactoe.models.features.game.Coordinate;
import com.citadel.tictactoe.views.console.core.ConsoleContext;

public class PutTargetCoordinateView extends PlacementCoordinateView {

    private Coordinate target;

    public PutTargetCoordinateView(CoordinateController coordinateController, ConsoleContext consoleContext) {
        super(coordinateController, consoleContext);
    }

    @Override
    Coordinate getCoordinate() {
        target = getCoordinateController().getTarget();
        getCoordinateController().accept(this);
        return target;
    }

    @Override
    public void visit(UserCoordinateController userCoordinateController) {
        getConsoleContext().coordinateView().read("En ", target);
    }

    @Override
    public void visit(MachineCoordinateController machineCoordinateController) {
        super.show("pone en", target);
    }
}
