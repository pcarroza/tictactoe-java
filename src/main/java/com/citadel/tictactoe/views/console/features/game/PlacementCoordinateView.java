package com.citadel.tictactoe.views.console.features.game;

import com.citadel.tictactoe.controllers.features.game.CoordinateController;
import com.citadel.tictactoe.controllers.features.game.CoordinateControllerVisitor;
import com.citadel.tictactoe.models.features.game.Coordinate;
import com.citadel.tictactoe.shared.Terminal;
import com.citadel.tictactoe.views.console.core.ConsoleContext;

abstract class PlacementCoordinateView implements CoordinateControllerVisitor {

    private final CoordinateController coordinateController;

    private final ConsoleContext consoleContext;

    PlacementCoordinateView(CoordinateController coordinateController, ConsoleContext consoleContext) {
        assert coordinateController != null;
        this.coordinateController = coordinateController;
        this.consoleContext = consoleContext;
    }

    abstract Coordinate getCoordinate();

    protected void show(String infix, Coordinate coordinate) {
        consoleContext.coordinateView().write("La maquina " + infix + " ", coordinate);
        Terminal.getInstance().readString(", Pulse enter para continuar");
    }

    protected CoordinateController getCoordinateController() {
        return coordinateController;
    }

    protected ConsoleContext getConsoleContext() {
        return consoleContext;
    }

}
