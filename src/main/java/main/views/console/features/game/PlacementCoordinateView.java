package main.views.console.features.game;

import main.controllers.features.game.CoordinateController;
import main.controllers.features.game.CoordinateControllerVisitor;
import main.models.features.game.Coordinate;
import main.shared.Terminal;

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
