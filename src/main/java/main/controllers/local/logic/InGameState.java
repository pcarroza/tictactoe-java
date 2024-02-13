package main.controllers.local.logic;

import main.controllers.local.LocalOperationController;
import main.controllers.local.LocalOperationControllerBuilder;

public class InGameState extends State {

    private final LocalOperationControllerBuilder builder;

    public InGameState(StatesBuilder statesBuilder, LocalOperationControllerBuilder builder) {
        super(statesBuilder);
        this.builder = builder;
    }

    @Override
    State end() {
        return this.statesBuilder.getEndState();
    }

    @Override
    LocalOperationController getController() {
        return this.builder.getPlacementController();
    }
}
