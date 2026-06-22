package main.controllers.features.game.local.logic;

import main.controllers.features.game.local.LocalOperationController;
import main.controllers.features.game.local.LocalOperationControllerBuilder;

public class InGameState extends GameState {

    private final LocalOperationControllerBuilder builder;

    public InGameState(GameStatesBuilder statesBuilder, LocalOperationControllerBuilder builder) {
        super(statesBuilder);
        this.builder = builder;
    }

    @Override
    GameState end() {
        return statesBuilder.getEndState();
    }

    @Override
    LocalOperationController getController() {
        return builder.getPlacementController();
    }
}
