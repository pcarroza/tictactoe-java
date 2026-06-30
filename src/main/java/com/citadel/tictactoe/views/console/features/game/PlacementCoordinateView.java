package com.citadel.tictactoe.views.console.features.game;

import com.citadel.tictactoe.controllers.features.game.CoordinateController;
import com.citadel.tictactoe.controllers.features.game.CoordinateControllerVisitor;
import com.citadel.tictactoe.models.features.game.Coordinate;
import com.citadel.tictactoe.shared.Terminal;

abstract class PlacementCoordinateView implements CoordinateControllerVisitor {

    private final CoordinateController coordinateController;

    PlacementCoordinateView(CoordinateController coordinateController) {
        assert coordinateController != null;
        this.coordinateController = coordinateController;
    }

    abstract Coordinate getCoordinate();

    protected void show(String infix, Coordinate coordinate) {
        CoordinateView.getInstance().write("La maquina " + infix + " ", coordinate);
        Terminal.getInstance().readString(", Pulse enter para continuar");
    }

    protected CoordinateController getCoordinateController() {
        return coordinateController;
    }

}
