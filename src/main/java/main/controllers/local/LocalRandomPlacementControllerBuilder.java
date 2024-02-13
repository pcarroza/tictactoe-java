package main.controllers.local;

import main.models.Game;

public class LocalRandomPlacementControllerBuilder extends LocalPlacementControllerBuilder {

    LocalRandomPlacementControllerBuilder(Game game) {
        super(game);
    }

    @Override
    public void buildPlacementController() {
        LocalCoordinateController[] controllers = {
                new LocalRandomCoordinateController(this.game),
                new LocalRandomCoordinateController(this.game)
        };
        this.buildPlacementController(controllers);
    }
}
