package com.citadel.tictactoe.controllers.modules.replay.local.logic;

import com.citadel.tictactoe.controllers.modules.replay.ReplayController;
import com.citadel.tictactoe.controllers.modules.replay.local.LocalReplayController;
import com.citadel.tictactoe.models.modules.game.ReplayBoard;

class ShowMoveReplayState extends ReplayState {

    private final ReplayBoard replayBoard;

    private final ExitReplayState exit;

    ShowMoveReplayState(ReplayBoard replayBoard, ExitReplayState exit) {
        this.replayBoard = replayBoard;
        this.exit = exit;
    }

    @Override
    ReplayController getController() {
        return new LocalReplayController(replayBoard);
    }

    @Override
    ReplayState exit() {
        return exit;
    }
}
