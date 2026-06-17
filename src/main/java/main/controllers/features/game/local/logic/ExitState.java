package main.controllers.features.game.local.logic;

import main.controllers.features.game.local.LocalOperationController;

public class ExitState extends State {

    public ExitState(StatesBuilder statesBuilder) {
        super(statesBuilder);
    }

    @Override
    LocalOperationController getController() {
        return null;
    }
}
