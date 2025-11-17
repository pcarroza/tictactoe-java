package main.controllers.modules.game.local;

import main.controllers.modules.game.CoordinateControllerVisitor;
import main.controllers.modules.game.UserCoordinateController;
import main.models.modules.game.Coordinate;
import main.models.modules.game.Game;

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
