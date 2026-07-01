package com.citadel.tictactoe.controllers.features.game.local.builders;

import com.citadel.tictactoe.controllers.features.game.local.LocalCoordinateController;
import com.citadel.tictactoe.controllers.features.game.local.LocalGameMoveController;
import com.citadel.tictactoe.controllers.features.game.local.LocalGamePlacementController;
import com.citadel.tictactoe.controllers.features.game.local.LocalGamePutController;
import com.citadel.tictactoe.models.features.game.Game;

import java.util.Arrays;

public abstract class LocalPlacementControllerBuilder {

    protected Game game;

    protected LocalGamePlacementController[] controllers;

    public LocalPlacementControllerBuilder(Game game) {
        assert game != null;
        this.game = game;
        controllers = new LocalGamePlacementController[2];
    }

    public abstract void buildPlacementController();

    void buildPlacementController(LocalCoordinateController[] localCoordinateControllers) {
        assert localCoordinateControllers != null;
        for (int i = 0; i < game.getNumberOfPlayers(); i++) {
            assert localCoordinateControllers[i] != null;
        }
        controllers[0] = new LocalGamePutController(game, localCoordinateControllers[0]);
        controllers[1] = new LocalGameMoveController(game, localCoordinateControllers[1]);
    }

    LocalGamePlacementController getPlacementController() {
        assert controllers != null;
        Arrays.stream(controllers).forEach(controller -> {
            assert controller != null;
        });
        return !game.isComplete() ? controllers[0] : controllers[1];
    }
}
