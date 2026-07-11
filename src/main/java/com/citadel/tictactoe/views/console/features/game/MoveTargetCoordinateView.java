package com.citadel.tictactoe.views.console.features.game;

import com.citadel.tictactoe.controllers.features.game.CoordinateController;
import com.citadel.tictactoe.controllers.features.game.MachineCoordinateController;
import com.citadel.tictactoe.controllers.features.game.UserCoordinateController;
import com.citadel.tictactoe.models.features.game.Coordinate;
import com.citadel.tictactoe.views.console.core.ConsoleContext;

public class MoveTargetCoordinateView extends PlacementCoordinateView {

    private final Coordinate origin;

    private Coordinate target;

    public MoveTargetCoordinateView(CoordinateController coordinateController, Coordinate origin, ConsoleContext consoleContext) {
        super(coordinateController, consoleContext);
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
        getConsoleContext().coordinateView().read("A", target);
    }

    @Override
    public void visit(MachineCoordinateController machineCoordinateController) {
        target = machineCoordinateController.getTarget(origin);
        super.show("pone en: ", target);
    }
}
