package com.citadel.tictactoe.controllers.modules.game.local;

import com.citadel.tictactoe.controllers.modules.game.CoordinateControllerVisitor;
import com.citadel.tictactoe.controllers.modules.game.UserCoordinateController;
import com.citadel.tictactoe.models.modules.game.Coordinate;
import com.citadel.tictactoe.models.modules.game.Game;

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
    public void accept(CoordinateControllerVisitor coordinateControllerVisitor) {
        coordinateControllerVisitor.visit(this);
    }
}
