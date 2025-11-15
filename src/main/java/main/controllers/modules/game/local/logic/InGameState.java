package main.controllers.modules.game.local.logic;

import main.controllers.modules.game.local.LocalOperationController;
import main.controllers.modules.game.local.LocalOperationControllerBuilder;

public class InGameState extends State {

    private final LocalOperationControllerBuilder builder;

    public InGameState(StatesBuilder statesBuilder, LocalOperationControllerBuilder builder) {
        super(statesBuilder);
        this.builder = builder;
    }

    @Override
    State end() {
        return statesBuilder.getEndState();
    }

    @Override
    LocalOperationController getController() {
        return builder.getPlacementController();
    }
}
