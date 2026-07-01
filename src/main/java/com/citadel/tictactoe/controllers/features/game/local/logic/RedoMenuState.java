package com.citadel.tictactoe.controllers.features.game.local.logic;

import com.citadel.tictactoe.controllers.features.game.local.LocalGameOperationController;
import com.citadel.tictactoe.controllers.features.game.local.builders.LocalOperationControllerBuilder;

class RedoMenuState extends GameState {

    private final LocalGameOperationController redoController;

    RedoMenuState(GameStatesBuilder statesBuilder, LocalOperationControllerBuilder builder) {
        super(statesBuilder);
        this.redoController = builder.getRedoController();
    }

    @Override
    GameState resume() {
        return statesBuilder.getInGameState();
    }

    @Override
    LocalGameOperationController getController() {
        return redoController;
    }

}
