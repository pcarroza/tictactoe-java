package com.citadel.tictactoe.controllers.features.game.local.builders;

import com.citadel.tictactoe.controllers.features.game.local.LocalCoordinateController;
import com.citadel.tictactoe.controllers.features.game.local.LocalRandomCoordinateController;
import com.citadel.tictactoe.models.features.game.Game;

public class LocalRandomPlacementControllerBuilder extends LocalPlacementControllerBuilder {

    LocalRandomPlacementControllerBuilder(Game game) {
        super(game);
    }

    @Override
    public void buildPlacementController() {
        LocalCoordinateController[] controllers = {
                new LocalRandomCoordinateController(super.game),
                new LocalRandomCoordinateController(super.game)
        };
        super.buildPlacementController(controllers);
    }
}
