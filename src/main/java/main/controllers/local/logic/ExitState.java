package main.controllers.local.logic;

import main.controllers.local.LocalOperationController;

public class ExitState extends State {

    public ExitState(StatesBuilder statesBuilder) {
        super(statesBuilder);
    }

    @Override
    LocalOperationController getController() {
        return null;
    }
}
