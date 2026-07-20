package com.citadel.tictactoe.views.console.modules.game;

import com.citadel.tictactoe.controllers.modules.game.CoordinateController;
import com.citadel.tictactoe.controllers.modules.game.CoordinateControllerVisitor;
import com.citadel.tictactoe.models.modules.game.Coordinate;
import com.citadel.tictactoe.shared.LimitedIntDialog;
import com.citadel.tictactoe.shared.Terminal;

abstract class PlacementCoordinateView implements CoordinateControllerVisitor {

    private final CoordinateController coordinateController;

    PlacementCoordinateView(CoordinateController coordinateController) {
        assert coordinateController != null;
        this.coordinateController = coordinateController;
    }

    abstract Coordinate getCoordinate();

    protected void show(String infix, Coordinate coordinate) {
        new CoordinateView(new LimitedIntDialog()).write("La maquina " + infix + " ", coordinate);
        Terminal.getInstance().readString(", Pulse enter para continuar");
    }

    protected CoordinateController getCoordinateController() {
        return coordinateController;
    }
}
