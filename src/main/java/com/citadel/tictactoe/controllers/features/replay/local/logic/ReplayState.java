package com.citadel.tictactoe.controllers.features.replay.local.logic;

import com.citadel.tictactoe.controllers.features.replay.ReplayController;
import com.citadel.tictactoe.models.features.game.Coordinate;
import com.citadel.tictactoe.models.features.game.Player;

abstract class ReplayState {

    abstract ReplayController getController(LocalReplayLogic logic);

    ReplayState next() {
        assert false;
        return null;
    }

    ReplayState previous() {
        assert false;
        return null;
    }

    ReplayState exit() {
        assert false;
        return null;
    }

    Player getColor(Coordinate coordinate) {
        assert false;
        return null;
    }

    int getPosition() {
        assert false;
        return 0;
    }

    int getTotal() {
        assert false;
        return 0;
    }

    boolean hasNext() {
        assert false;
        return false;
    }

    boolean hasPrevious() {
        assert false;
        return false;
    }
}
