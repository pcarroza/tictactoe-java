package main.controllers.local;

import main.models.Game;

import java.util.Arrays;

public abstract class LocalPlacementControllerBuilder {

    protected Game game;

    protected LocalPlacementController[] controllers;

    public LocalPlacementControllerBuilder(Game game) {
        assert game != null;
        this.game = game;
        this.controllers = new LocalPlacementController[2];
    }

    public abstract void buildPlacementController();

    void buildPlacementController(LocalCoordinateController[] localCoordinateControllers) {
        assert localCoordinateControllers != null;
        for (int i = 0; i < this.game.getNumberOfPlayers(); i++) {
            assert localCoordinateControllers[i] != null;
        }
        this.controllers[0] = new LocalPutController(game, localCoordinateControllers[0]);
        this.controllers[1] = new LocalMoveController(game, localCoordinateControllers[1]);
    }

    LocalPlacementController getPlacementController() {
        assert this.controllers != null;
        Arrays.stream(this.controllers).forEach(controller -> {
            assert controller != null;
        });
        return !this.game.isComplete() ? this.controllers[0] : this.controllers[1];
    }
}
