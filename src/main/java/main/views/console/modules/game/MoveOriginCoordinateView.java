package main.views.console.modules.game;

import main.controllers.modules.game.CoordinateController;
import main.controllers.modules.game.RandomCoordinateController;
import main.controllers.modules.game.UserCoordinateController;
import main.models.Coordinate;

public class MoveOriginCoordinateView extends PlacementCoordinateView {

    private Coordinate origin;

    public MoveOriginCoordinateView(CoordinateController coordinateController) {
        super(coordinateController);
    }

    @Override
    Coordinate getCoordinate() {
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
