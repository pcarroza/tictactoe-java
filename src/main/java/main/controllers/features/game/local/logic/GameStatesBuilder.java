package main.controllers.features.game.local.logic;

import main.controllers.features.game.local.LocalOperationControllerBuilder;

public class GameStatesBuilder {

    private final InitialGameState initialState;

    private final InGameState inGameState;

    private final EndGameState finalState;

    private final ExitGameState exitState;

    public GameStatesBuilder(LocalOperationControllerBuilder builder) {
        initialState = new InitialGameState(this, builder);
        inGameState = new InGameState(this, builder);
        finalState = new EndGameState(this, builder);
        exitState = new ExitGameState(this);
    }

    InitialGameState getInitialState() {
        return initialState;
    }

    InGameState getInGameState() {
        return inGameState;
    }

    EndGameState getEndState() {
        return finalState;
    }

    ExitGameState getExistState() {
        return exitState;
    }
}
