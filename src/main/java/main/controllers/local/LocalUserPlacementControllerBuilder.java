package main.controllers.local;

import main.models.Game;

public class LocalUserPlacementControllerBuilder extends LocalPlacementControllerBuilder {

    LocalUserPlacementControllerBuilder(Game game) {
        super(game);
    }

    @Override
    public void buildPlacementController() {
        LocalCoordinateController[] controllers = {
                new LocalUserCoordinateController(this.game),
                new LocalUserCoordinateController(this.game)
        };
        this.buildPlacementController(controllers);
    }
}
