package main.views.console;

import main.controllers.CoordinateController;
import main.controllers.RandomCoordinateController;
import main.controllers.UserCoordinateController;
import main.models.Coordinate;

public class MoveOriginCoordinateView extends PlacementCoordinateView {

    private Coordinate origin;

    public MoveOriginCoordinateView(CoordinateController coordinateController) {
        super(coordinateController);
    }

    @Override
    Coordinate getCoordinate() {
        this.origin = this.getCoordinateController().getOrigin();
        this.getCoordinateController().accept(this);
        return this.origin;
    }

    @Override
    public void visit(UserCoordinateController userCoordinateController) {
        CoordinateView.getInstance().read("De", this.origin);
    }

    @Override
    public void visit(RandomCoordinateController randomCoordinateController) {
        this.show("quita de", this.origin);
    }
}
