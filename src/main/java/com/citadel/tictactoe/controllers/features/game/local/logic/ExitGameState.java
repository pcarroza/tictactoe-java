package com.citadel.tictactoe.controllers.features.game.local.logic;

import com.citadel.tictactoe.controllers.features.game.local.LocalGameOperationController;

public class ExitGameState extends GameState {

    public ExitGameState(GameStatesBuilder statesBuilder) {
        super(statesBuilder);
    }

    @Override
    LocalGameOperationController getController() {
        return null;
    }
}
