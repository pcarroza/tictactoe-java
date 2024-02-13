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
        this.target = this.getCoordinateController().getTarget();
        this.getCoordinateController().accept(this);
        return this.target;
    }

    @Override
    public void visit(UserCoordinateController userCoordinateController) {
        CoordinateView.getInstance().read("En ", this.target);
    }

    @Override
    public void visit(RandomCoordinateController randomCoordinateController) {
        this.show("pone en", this.target);
    }
}
