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
        getCoordinateController().accept(this);
        return target;
    }

    @Override
    public void visit(UserCoordinateController userCoordinateController) {
        target = userCoordinateController.getTarget();
        CoordinateView.getInstance().read("A", target);
    }

    @Override
    public void visit(RandomCoordinateController randomCoordinateController) {
        target = randomCoordinateController.getTarget(origin);
        super.show("pone en: ", target);
    }
}
