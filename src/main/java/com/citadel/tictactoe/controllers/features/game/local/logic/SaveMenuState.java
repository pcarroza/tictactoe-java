package com.citadel.tictactoe.controllers.features.game.local.logic;

import com.citadel.tictactoe.controllers.features.game.local.LocalGameOperationController;
import com.citadel.tictactoe.controllers.features.game.local.LocalGameSaveController;
import com.citadel.tictactoe.controllers.features.game.local.builders.LocalOperationControllerBuilder;

class SaveMenuState extends GameState {

    private final LocalGameSaveController localSaveController;

    SaveMenuState(GameStatesBuilder statesBuilder, LocalOperationControllerBuilder builder) {
        super(statesBuilder);
        this.localSaveController = builder.getSaveController();
    }

    @Override
    GameState resume() {
        return statesBuilder.getInGameState();
    }

    @Override
    GameState exit() {
        return statesBuilder.getExistState();
    }

    @Override
    LocalGameOperationController getController() {
        return localSaveController;
    }
}
