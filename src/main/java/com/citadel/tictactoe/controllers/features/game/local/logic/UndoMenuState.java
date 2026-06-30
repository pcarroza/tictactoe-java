package com.citadel.tictactoe.controllers.features.game.local.logic;

import com.citadel.tictactoe.controllers.features.game.local.LocalOperationController;
import com.citadel.tictactoe.controllers.features.game.local.LocalOperationControllerBuilder;

class UndoMenuState extends GameState {

    private final LocalOperationController undoController;

    UndoMenuState(GameStatesBuilder statesBuilder, LocalOperationControllerBuilder builder) {
        super(statesBuilder);
        this.undoController = builder.getUndoController();
    }

    @Override
    GameState resume() {
        return statesBuilder.getInGameState();
    }

    @Override
    LocalOperationController getController() {
        return undoController;
    }

}
