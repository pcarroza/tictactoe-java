package main.controllers.local;

import main.models.Game;

import java.util.Arrays;

public abstract class LocalPlacementControllerBuilder {

    protected Game game;

    protected LocalPlacementController[] controllers;

    public LocalPlacementControllerBuilder(Game game) {
        assert game != null;
        this.game = game;
        controllers = new LocalPlacementController[2];
    }

    public abstract void buildPlacementController();

    void buildPlacementController(LocalCoordinateController[] localCoordinateControllers) {
        assert localCoordinateControllers != null;
        for (int i = 0; i < game.getNumberOfPlayers(); i++) {
            assert localCoordinateControllers[i] != null;
        }
        controllers[0] = new LocalPutController(game, localCoordinateControllers[0]);
        controllers[1] = new LocalMoveController(game, localCoordinateControllers[1]);
    }

    LocalPlacementController getPlacementController() {
        assert controllers != null;
        Arrays.stream(controllers).forEach(controller -> {
            assert controller != null;
        });
        return !game.isComplete() ? controllers[0] : controllers[1];
    }
}
