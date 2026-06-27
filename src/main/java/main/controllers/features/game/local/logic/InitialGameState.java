package main.controllers.features.game.local.logic;

import main.controllers.features.game.local.LocalOperationControllerBuilder;
import main.controllers.features.game.local.LocalOperationController;
import main.controllers.features.game.local.LocalStartController;

public class InitialGameState extends GameState {

    private final LocalStartController localStartController;

    public InitialGameState(GameStatesBuilder statesBuilder, LocalOperationControllerBuilder builder) {
        super(statesBuilder);
        localStartController = builder.getStartController();
    }

    @Override
    GameState begin() {
        return statesBuilder.getInGameState();
    }

    @Override
    LocalOperationController getController() {
        return localStartController;
    }
}
