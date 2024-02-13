package main.controllers.local.logic;

import main.controllers.local.LocalOperationControllerBuilder;

public class StatesBuilder {

    private final InitialState initialState;

    private final InGameState inGameState;

    private final EndState finalState;

    private final ExitState exitState;

    public StatesBuilder(LocalOperationControllerBuilder builder) {
        this.initialState = new InitialState(this, builder);
        this.inGameState = new InGameState(this, builder);
        this.finalState = new EndState(this, builder);
        this.exitState = new ExitState(this);
    }

    InitialState getInitialState() {
        return this.initialState;
    }

    InGameState getInGameState() {
        return this.inGameState;
    }

    EndState getEndState() {
        return this.finalState;
    }

    ExitState getExistState() {
        return this.exitState;
    }
}
