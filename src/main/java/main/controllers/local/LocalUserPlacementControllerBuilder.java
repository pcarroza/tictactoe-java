package main.controllers.local;

import main.models.Game;

public class LocalUserPlacementControllerBuilder extends LocalPlacementControllerBuilder {

    LocalUserPlacementControllerBuilder(Game game) {
        super(game);
    }

    @Override
    public void build() {
        LocalCoordinateController[] controllers = {
                new LocalUserCoordinateController(this.game),
                new LocalUserCoordinateController(this.game)
        };
        this.build(controllers);
    }
}
