package com.citadel.tictactoe.controllers.features.game.local.logic;

import com.citadel.tictactoe.controllers.features.game.local.LocalOperationControllerBuilder;

public class GameStatesBuilder {

    private final InitialGameState initialState;

    private final InGameState inGameState;

    private final EndGameState finalState;

    private final ExitGameState exitState;

    private final SaveMenuState saveMenuState;

    private final UndoMenuState undoMenuState;

    private final RedoMenuState redoMenuState;

    public GameStatesBuilder(LocalOperationControllerBuilder builder) {
        initialState = new InitialGameState(this, builder);
        inGameState = new InGameState(this, builder);
        finalState = new EndGameState(this, builder);
        saveMenuState = new SaveMenuState(this, builder);
        undoMenuState = new UndoMenuState(this, builder);
        redoMenuState = new RedoMenuState(this, builder);
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

    UndoMenuState getUndoMenuState() {
        return undoMenuState;
    }

    RedoMenuState getRedoMenuState() {
        return redoMenuState;
    }

}
