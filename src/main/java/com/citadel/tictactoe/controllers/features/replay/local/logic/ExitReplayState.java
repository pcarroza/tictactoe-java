package com.citadel.tictactoe.controllers.features.replay.local.logic;

import com.citadel.tictactoe.controllers.features.replay.ReplayController;

class ExitReplayState extends ReplayState {

    @Override
    ReplayController getController() {
        return null;
    }

    @Override
    ReplayState exit() {
        return this;
    }

}
