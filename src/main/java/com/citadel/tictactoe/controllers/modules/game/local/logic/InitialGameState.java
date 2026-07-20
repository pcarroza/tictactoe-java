package com.citadel.tictactoe.controllers.modules.game.local.logic;

import com.citadel.tictactoe.controllers.modules.game.local.LocalGameOperationController;
import com.citadel.tictactoe.controllers.modules.game.local.LocalGameStartController;
import com.citadel.tictactoe.controllers.modules.game.local.builders.LocalOperationControllerBuilder;

public class InitialGameState extends GameState {

    private final LocalGameStartController localStartController;

    public InitialGameState(GameStatesBuilder statesBuilder, LocalOperationControllerBuilder builder) {
        super(statesBuilder);
        localStartController = builder.getStartController();
    }

    @Override
    GameState begin() {
        return statesBuilder.getInGameState();
    }

    @Override
    LocalGameOperationController getController() {
        return localStartController;
    }
}
