package main.controllers.features.game.local.logic;

import main.controllers.features.game.local.LocalContinueController;
import main.controllers.features.game.local.LocalOperationController;
import main.controllers.features.game.local.LocalOperationControllerBuilder;

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
