package main.controllers.features.game.local.logic;

import main.controllers.features.game.local.LocalOperationController;

abstract class GameState {

    protected GameStatesBuilder statesBuilder;

    protected GameState(GameStatesBuilder statesBuilder) {
        this.statesBuilder = statesBuilder;
    }

    GameState initialize() {
        assert false;
        return null;
    }

    GameState begin() {
        assert false;
        return null;
    }

    GameState end() {
        assert false;
        return null;
    }

    GameState exit() {
        assert false;
        return null;
    }

    GameState save() {
        assert false;
        return null;
    }

    GameState resume() {
        assert false;
        return null;
    }

    abstract LocalOperationController getController();
}
