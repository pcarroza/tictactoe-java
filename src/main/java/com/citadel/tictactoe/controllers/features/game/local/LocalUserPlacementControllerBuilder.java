package com.citadel.tictactoe.controllers.features.game.local;

import com.citadel.tictactoe.models.features.game.Game;

public class LocalUserPlacementControllerBuilder extends LocalPlacementControllerBuilder {

    LocalUserPlacementControllerBuilder(Game game) {
        super(game);
    }

    @Override
    public void buildPlacementController() {
        LocalCoordinateController[] controllers = {
                new LocalUserCoordinateController(super.game),
                new LocalUserCoordinateController(super.game)
        };
        super.buildPlacementController(controllers);
    }
}
