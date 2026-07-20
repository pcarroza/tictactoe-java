package com.citadel.tictactoe.controllers.modules.game.local.logic;

import com.citadel.tictactoe.controllers.modules.game.local.LocalGameOperationController;
import com.citadel.tictactoe.controllers.modules.game.local.builders.LocalOperationControllerBuilder;

class UndoMenuState extends GameState {

    private final LocalGameOperationController undoController;

    UndoMenuState(GameStatesBuilder statesBuilder, LocalOperationControllerBuilder builder) {
        super(statesBuilder);
        this.undoController = builder.getUndoController();
    }

    @Override
    GameState resume() {
        return statesBuilder.getInGameState();
    }

    @Override
    LocalGameOperationController getController() {
        return undoController;
    }

}
