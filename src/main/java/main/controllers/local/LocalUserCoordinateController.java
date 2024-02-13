package main.controllers.local;

import main.controllers.CoordinateControllerVisitor;
import main.controllers.UserCoordinateController;
import main.models.Coordinate;
import main.models.Game;

public class LocalUserCoordinateController extends LocalCoordinateController
    implements UserCoordinateController {

    public LocalUserCoordinateController(Game game) {
        super(game);
    }

    @Override
    public Coordinate getOrigin() {
        return new Coordinate();
    }

    @Override
    public Coordinate getTarget() {
        return new Coordinate();
    }

    @Override
    public void accept(CoordinateControllerVisitor visitor) {
        visitor.visit(this);
    }
}
