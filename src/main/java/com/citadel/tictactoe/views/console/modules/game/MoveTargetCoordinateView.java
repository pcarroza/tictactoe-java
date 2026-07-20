package com.citadel.tictactoe.views.console.modules.game;

import com.citadel.tictactoe.controllers.modules.game.CoordinateController;
import com.citadel.tictactoe.controllers.modules.game.MachineCoordinateController;
import com.citadel.tictactoe.controllers.modules.game.UserCoordinateController;
import com.citadel.tictactoe.models.modules.game.Coordinate;
import com.citadel.tictactoe.shared.LimitedIntDialog;

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
        new CoordinateView(new LimitedIntDialog()).read("A", target);
    }

    @Override
    public void visit(MachineCoordinateController machineCoordinateController) {
        target = machineCoordinateController.getTarget(origin);
        super.show("pone en: ", target);
    }
}
