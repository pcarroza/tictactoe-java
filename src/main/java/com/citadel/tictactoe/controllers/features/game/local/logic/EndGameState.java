package com.citadel.tictactoe.controllers.features.game.local.logic;

import com.citadel.tictactoe.controllers.features.game.local.LocalContinueController;
import com.citadel.tictactoe.controllers.features.game.local.LocalOperationController;
import com.citadel.tictactoe.controllers.features.game.local.LocalOperationControllerBuilder;

class EndGameState extends GameState {

    private final LocalContinueController localContinueController;

    EndGameState(GameStatesBuilder statesBuilder, LocalOperationControllerBuilder builder) {
        super(statesBuilder);
        localContinueController = builder.getContinueController();
    }

    @Override
    GameState initialize() {
        return statesBuilder.getInitialState();
    }

    @Override
    GameState exit() {
        return statesBuilder.getExistState();
    }

    @Override
    LocalOperationController getController() {
        return localContinueController;
    }
}
