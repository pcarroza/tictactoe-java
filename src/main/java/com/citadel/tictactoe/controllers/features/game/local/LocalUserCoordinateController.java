package com.citadel.tictactoe.controllers.features.game.local;

import com.citadel.tictactoe.controllers.features.game.CoordinateControllerVisitor;
import com.citadel.tictactoe.controllers.features.game.UserCoordinateController;
import com.citadel.tictactoe.models.features.game.Coordinate;
import com.citadel.tictactoe.models.features.game.Game;

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
