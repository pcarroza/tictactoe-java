package com.citadel.tictactoe.controllers.features.replay.local;

import com.citadel.tictactoe.controllers.features.replay.ReplayController;

class ExitReplayState extends ReplayState {

    @Override
    ReplayController getController(LocalReplayLogic logic) {
        return null;
    }

    @Override
    ReplayState exit() {
        return this;
    }

}
