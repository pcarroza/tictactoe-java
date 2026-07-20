package com.citadel.tictactoe.controllers.modules.game.local.builders;

import com.citadel.tictactoe.controllers.modules.game.local.LocalCoordinateController;
import com.citadel.tictactoe.controllers.modules.game.local.LocalUserCoordinateController;
import com.citadel.tictactoe.models.modules.game.Game;

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
