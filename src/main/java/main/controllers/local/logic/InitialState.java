package main.controllers.local.logic;

import main.controllers.local.LocalOperationControllerBuilder;
import main.controllers.local.LocalOperationController;
import main.controllers.local.LocalStartController;

public class InitialState extends State {

    private final LocalStartController localStartController;

    public InitialState(StatesBuilder statesBuilder, LocalOperationControllerBuilder builder) {
        super(statesBuilder);
        this.localStartController = builder.getStartController();
    }

    @Override
    State begin() {
        return this.statesBuilder.getInGameState();
    }

    @Override
    LocalOperationController getController() {
        return this.localStartController;
    }
}
