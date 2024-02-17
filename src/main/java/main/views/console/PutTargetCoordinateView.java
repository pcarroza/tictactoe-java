package main.views.console;

import main.controllers.*;
import main.models.Coordinate;

public class PutTargetCoordinateView extends PlacementCoordinateView {

    private Coordinate target;

    public PutTargetCoordinateView(CoordinateController coordinateController) {
        super(coordinateController);
    }

    @Override
    Coordinate getCoordinate() {
        target = getCoordinateController().getTarget();
        getCoordinateController().accept(this);
        return target;
    }

    @Override
    public void visit(UserCoordinateController userCoordinateController) {
        CoordinateView.getInstance().read("En ", target);
    }

    @Override
    public void visit(RandomCoordinateController randomCoordinateController) {
        super.show("pone en", target);
    }
}
