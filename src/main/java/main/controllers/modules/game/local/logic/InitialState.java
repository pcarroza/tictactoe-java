package main.controllers.modules.game.local.logic;

import main.controllers.modules.game.local.LocalOperationControllerBuilder;
import main.controllers.modules.game.local.LocalOperationController;
import main.controllers.modules.game.local.LocalStartController;

public class InitialState extends State {

    private final LocalStartController localStartController;

    public InitialState(StatesBuilder statesBuilder, LocalOperationControllerBuilder builder) {
        super(statesBuilder);
        localStartController = builder.getStartController();
    }

    @Override
    State begin() {
        return statesBuilder.getInGameState();
    }

    @Override
    LocalOperationController getController() {
        return localStartController;
    }
}
