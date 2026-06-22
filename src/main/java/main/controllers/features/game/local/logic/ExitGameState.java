package main.controllers.features.game.local.logic;

import main.controllers.features.game.local.LocalOperationController;

public class ExitGameState extends GameState {

    public ExitGameState(GameStatesBuilder statesBuilder) {
        super(statesBuilder);
    }

    @Override
    LocalOperationController getController() {
        return null;
    }
}
