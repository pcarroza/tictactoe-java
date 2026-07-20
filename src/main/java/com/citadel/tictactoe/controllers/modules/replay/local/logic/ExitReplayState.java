package com.citadel.tictactoe.controllers.modules.replay.local.logic;

import com.citadel.tictactoe.controllers.modules.replay.ReplayController;

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
