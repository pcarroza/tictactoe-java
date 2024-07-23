package main.views.console;

import main.controllers.CoordinateController;
import main.controllers.RandomCoordinateController;
import main.controllers.UserCoordinateController;
import main.models.Coordinate;
import main.views.console.tools.GameManager;

public class MoveOriginCoordinateView extends PlacementCoordinateView {

    private Coordinate origin;

    public MoveOriginCoordinateView(CoordinateController coordinateController) {
        super(coordinateController);
    }

    @Override
    public Coordinate getCoordinate() {
        origin = getCoordinateController().getOrigin();
        getCoordinateController().accept(this);
        return origin;
    }

    @Override
    public void visit(UserCoordinateController userCoordinateController) {
        CoordinateView.getInstance().read("De", origin);
    }

    @Override
    public void visit(RandomCoordinateController randomCoordinateController) {
        this.show("quita de", origin);
    }
}
