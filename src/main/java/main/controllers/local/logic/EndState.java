package main.controllers.local.logic;

import main.controllers.local.LocalContinueController;
import main.controllers.local.LocalOperationController;
import main.controllers.local.LocalOperationControllerBuilder;

class EndState extends State {

    private final LocalContinueController localContinueController;

    EndState(StatesBuilder statesBuilder, LocalOperationControllerBuilder builder) {
        super(statesBuilder);
        localContinueController = builder.getContinueController();
    }

    @Override
    State initialize() {
        return statesBuilder.getInitialState();
    }

    @Override
    State exit() {
        return statesBuilder.getExistState();
    }

    @Override
    LocalOperationController getController() {
        return localContinueController;
    }
}
