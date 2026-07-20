package com.citadel.tictactoe.controllers.modules.replay.local.logic;

import com.citadel.tictactoe.controllers.modules.replay.ReplayController;

abstract class ReplayState {

    abstract ReplayController getController();

    ReplayState exit() {
        assert false;
        return null;
    }
}
