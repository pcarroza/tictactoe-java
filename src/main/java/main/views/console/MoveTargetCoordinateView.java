package main.views.console;

import main.controllers.CoordinateController;
import main.controllers.RandomCoordinateController;
import main.controllers.UserCoordinateController;
import main.models.Coordinate;

public class MoveTargetCoordinateView extends PlacementCoordinateView {

    private Coordinate origin;

    private Coordinate target;

    public MoveTargetCoordinateView(CoordinateController coordinateController) {
        super(coordinateController);
    }

    @Override
    public Coordinate getCoordinate() {
        getCoordinateController().accept(this);
        return target;
    }

    public void setCoordinateOrigin(Coordinate coordinate) {
        origin = coordinate;
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
