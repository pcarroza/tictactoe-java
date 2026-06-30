package com.citadel.tictactoe.controllers.features.game.local;

import com.citadel.tictactoe.controllers.features.game.CoordinateController;
import com.citadel.tictactoe.models.features.game.Coordinate;
import com.citadel.tictactoe.models.features.game.Game;

public abstract class LocalCoordinateController extends LocalController
        implements CoordinateController {

    protected LocalCoordinateController(Game game) {
        super(game);
    }

    public abstract Coordinate getOrigin();

    public abstract Coordinate getTarget();
}
