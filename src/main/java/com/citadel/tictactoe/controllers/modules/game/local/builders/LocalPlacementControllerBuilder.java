package com.citadel.tictactoe.controllers.modules.game.local.builders;

import com.citadel.tictactoe.controllers.modules.game.local.LocalCoordinateController;
import com.citadel.tictactoe.controllers.modules.game.local.LocalGameMoveController;
import com.citadel.tictactoe.controllers.modules.game.local.LocalGamePlacementController;
import com.citadel.tictactoe.controllers.modules.game.local.LocalGamePutController;
import com.citadel.tictactoe.controllers.modules.game.validation.CoordinateValidator;
import com.citadel.tictactoe.controllers.modules.game.validation.OccupiedValidator;
import com.citadel.tictactoe.controllers.modules.game.validation.OwnPieceValidator;
import com.citadel.tictactoe.controllers.modules.game.validation.RepeatedCoordinateValidator;
import com.citadel.tictactoe.models.modules.game.Game;

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
        CoordinateValidator putTargetChain = new OccupiedValidator();

        CoordinateValidator moveTargetChain = new OccupiedValidator();
        moveTargetChain.setNext(new RepeatedCoordinateValidator());

        CoordinateValidator moveOriginChain = new OwnPieceValidator();

        controllers[0] = new LocalGamePutController(game, localCoordinateControllers[0], putTargetChain);
        controllers[1] = new LocalGameMoveController(game, localCoordinateControllers[1], moveTargetChain, moveOriginChain);
    }

    LocalGamePlacementController getPlacementController() {
        assert controllers != null;
        Arrays.stream(controllers).forEach(controller -> {
            assert controller != null;
        });
        return !game.isComplete() ? controllers[0] : controllers[1];
    }
}
