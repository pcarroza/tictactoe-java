package com.citadel.tictactoe.controllers.features.replay.local.logic;

import com.citadel.tictactoe.controllers.features.replay.ReplayController;

abstract class ReplayState {

    abstract ReplayController getController();

    ReplayState exit() {
        assert false;
        return null;
    }
}
