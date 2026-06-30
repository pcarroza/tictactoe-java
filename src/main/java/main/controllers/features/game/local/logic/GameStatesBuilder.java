package main.controllers.features.game.local.logic;

import main.controllers.features.game.local.LocalOperationControllerBuilder;

public class GameStatesBuilder {

    private final InitialGameState initialState;

    private final InGameState inGameState;

    private final EndGameState finalState;

    private final ExitGameState exitState;

    private final SaveMenuState saveMenuState;

    public GameStatesBuilder(LocalOperationControllerBuilder builder) {
        initialState = new InitialGameState(this, builder);
        inGameState = new InGameState(this, builder);
        finalState = new EndGameState(this, builder);
        saveMenuState = new SaveMenuState(this, builder);
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

    SaveMenuState getSaveMenuState() {
        return saveMenuState;
    }
}
