package main.controllers.local;

import main.models.Game;

public class LocalRandomPlacementControllerBuilder extends LocalPlacementControllerBuilder {

    LocalRandomPlacementControllerBuilder(Game game) {
        super(game);
    }

    @Override
    public void build() {
        LocalCoordinateController[] controllers = {
                new LocalRandomCoordinateController(super.game),
                new LocalRandomCoordinateController(super.game)
        };
        super.build(controllers);
    }
}
