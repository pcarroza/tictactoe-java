package main.controllers.local.logic;

import main.controllers.local.LocalOperationControllerBuilder;

public class StatesBuilder {

    private final InitialState initialState;

    private final InGameState inGameState;

    private final EndState finalState;

    private final ExitState exitState;

    public StatesBuilder(LocalOperationControllerBuilder builder) {
        initialState = new InitialState(this, builder);
        inGameState = new InGameState(this, builder);
        finalState = new EndState(this, builder);
        exitState = new ExitState(this);
    }

    InitialState getInitialState() {
        return initialState;
    }

    InGameState getInGameState() {
        return inGameState;
    }

    EndState getEndState() {
        return finalState;
    }

    ExitState getExistState() {
        return exitState;
    }
}
