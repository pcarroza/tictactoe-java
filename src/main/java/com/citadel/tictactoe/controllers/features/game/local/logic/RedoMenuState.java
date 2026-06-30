package com.citadel.tictactoe.controllers.features.game.local.logic;

import com.citadel.tictactoe.controllers.features.game.local.LocalOperationController;
import com.citadel.tictactoe.controllers.features.game.local.LocalOperationControllerBuilder;

class RedoMenuState extends GameState {

    private final LocalOperationController redoController;

    RedoMenuState(GameStatesBuilder statesBuilder, LocalOperationControllerBuilder builder) {
        super(statesBuilder);
        this.redoController = builder.getRedoController();
    }

    @Override
    GameState resume() {
        return statesBuilder.getInGameState();
    }

    @Override
    LocalOperationController getController() {
        return redoController;
    }

}
