package main.controllers.modules.game.local.logic;

import main.controllers.modules.game.local.LocalContinueController;
import main.controllers.modules.game.local.LocalOperationController;
import main.controllers.modules.game.local.LocalOperationControllerBuilder;

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
