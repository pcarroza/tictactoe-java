package main.views.console;

import main.common.utils.Terminal;
import main.controllers.CoordinateController;
import main.controllers.CoordinateControllerVisitor;
import main.models.Coordinate;

public abstract class PlacementCoordinateView implements CoordinateControllerVisitor {

    private final CoordinateController coordinateController;

    public PlacementCoordinateView(CoordinateController coordinateController) {
        assert coordinateController != null;
        this.coordinateController = coordinateController;
    }

    public abstract Coordinate getCoordinate();

    protected void show(String infix, Coordinate coordinate) {
        CoordinateView.getInstance().write("La maquina " + infix + " ", coordinate);
        Terminal.getInstance().readString(", Pulse enter para continuar");
    }

    protected CoordinateController getCoordinateController() {
        return coordinateController;
    }

    public void setCoordinateOrigin(Coordinate coordinate) {
        assert false;
    }
}
