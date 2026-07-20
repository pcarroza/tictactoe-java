package com.citadel.tictactoe.controllers.modules.game.local.logic;

import com.citadel.tictactoe.controllers.modules.game.local.LocalGameOperationController;
import com.citadel.tictactoe.controllers.modules.game.local.builders.LocalOperationControllerBuilder;

public class InGameState extends GameState {

    private final LocalOperationControllerBuilder builder;

    public InGameState(GameStatesBuilder statesBuilder, LocalOperationControllerBuilder builder) {
        super(statesBuilder);
        this.builder = builder;
    }

    @Override
    GameState end() {
        return statesBuilder.getEndState();
    }

    @Override
    GameState exit() {
        return statesBuilder.getExistState();
    }

    @Override
    GameState save() {
        return statesBuilder.getSaveMenuState();
    }

    @Override
    GameState undo() {
        return statesBuilder.getUndoMenuState();
    }

    @Override
    GameState redo() {
        return statesBuilder.getRedoMenuState();
    }

    @Override
    LocalGameOperationController getController() {
        return builder.getPlacementController();
    }
}
