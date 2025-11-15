package main.controllers.modules.game.local;

import main.models.Game;

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
