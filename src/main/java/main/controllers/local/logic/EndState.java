package main.controllers.local.logic;

import main.controllers.local.LocalContinueController;
import main.controllers.local.LocalOperationController;
import main.controllers.local.LocalOperationControllerBuilder;

class EndState extends State {

    private final LocalContinueController localContinueController;

    EndState(StatesBuilder statesBuilder, LocalOperationControllerBuilder builder) {
        super(statesBuilder);
        this.localContinueController = builder.getContinueController();
    }

    @Override
    State initialize() {
        return this.statesBuilder.getInitialState();
    }

    @Override
    State exit() {
        return this.statesBuilder.getExistState();
    }

    @Override
    LocalOperationController getController() {
        return this.localContinueController;
    }
}
