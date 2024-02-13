package main.views.console;

import main.controllers.RandomCoordinateController;
import main.controllers.UserCoordinateController;
import main.controllers.CoordinateController;
import main.models.Coordinate;

public class MoveTargetCoordinateView extends PlacementCoordinateView {

    private final Coordinate origin;

    private Coordinate target;

    public MoveTargetCoordinateView(CoordinateController coordinateController, Coordinate origin) {
        super(coordinateController);
        assert origin != null;
        this.origin = origin;
    }

    @Override
    Coordinate getCoordinate() {
        this.getCoordinateController().accept(this);
        return this.target;
    }

    @Override
    public void visit(UserCoordinateController userCoordinateController) {
        this.target = userCoordinateController.getTarget();
        CoordinateView.getInstance().read("A", this.target);
    }

    @Override
    public void visit(RandomCoordinateController randomCoordinateController) {
        this.target = randomCoordinateController.getTarget(this.origin);
        this.show("pone en: ", this.target);
    }
}
