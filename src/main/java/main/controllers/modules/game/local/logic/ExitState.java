package main.controllers.modules.game.local.logic;

import main.controllers.modules.game.local.LocalOperationController;

public class ExitState extends State {

    public ExitState(StatesBuilder statesBuilder) {
        super(statesBuilder);
    }

    @Override
    LocalOperationController getController() {
        return null;
    }
}
