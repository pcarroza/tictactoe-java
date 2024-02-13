package main.views.console;

import main.models.Coordinate;
import main.utils.LimitedIntDialog;
import main.utils.Terminal;

public class CoordinateView {

    private static CoordinateView coordinateView;

    public static CoordinateView getInstance() {
        if (coordinateView == null) {
            coordinateView = new CoordinateView();
        }
        return coordinateView;
    }

    private CoordinateView() {}

    public static CoordinateView instance() {
        if (coordinateView != null) {
            coordinateView = new CoordinateView();
        }
        return coordinateView;
    }

    public void write(String title, Coordinate coordinate) {
        assert title != null;
        assert coordinate != null;
        Terminal.getInstance().write(title + "[" + (coordinate.getRow()) + "," + (coordinate.getColumn()) + "]");
    }

    public void read(String title, Coordinate target) {
        assert title != null;
        assert target != null;
        target.setRow(LimitedIntDialog.instance().read("Fila?", Coordinate.DIMENSION));
        target.setColumn(LimitedIntDialog.instance().read("Columna?", Coordinate.DIMENSION));
    }
}
