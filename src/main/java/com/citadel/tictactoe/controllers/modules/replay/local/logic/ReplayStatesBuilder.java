package com.citadel.tictactoe.controllers.modules.replay.local.logic;

import com.citadel.tictactoe.models.modules.game.ReplayBoard;

class ReplayStatesBuilder {

    private final ShowMoveReplayState showMoveState;

    ReplayStatesBuilder(ReplayBoard replayBoard) {
        ExitReplayState exit = new ExitReplayState();
        showMoveState = new ShowMoveReplayState(replayBoard, exit);
    }

    ShowMoveReplayState getShowMoveState() {
        return showMoveState;
    }
}
