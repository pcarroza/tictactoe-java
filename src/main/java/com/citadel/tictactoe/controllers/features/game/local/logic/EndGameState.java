package com.citadel.tictactoe.controllers.features.game.local.logic;

import com.citadel.tictactoe.controllers.features.game.local.LocalGameContinueController;
import com.citadel.tictactoe.controllers.features.game.local.LocalGameOperationController;
import com.citadel.tictactoe.controllers.features.game.local.builders.LocalOperationControllerBuilder;

class EndGameState extends GameState {

    private final LocalGameContinueController localContinueController;

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
    LocalGameOperationController getController() {
        return localContinueController;
    }
}
