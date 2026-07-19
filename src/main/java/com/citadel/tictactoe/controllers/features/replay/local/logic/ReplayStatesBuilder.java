package com.citadel.tictactoe.controllers.features.replay.local.logic;

import com.citadel.tictactoe.models.features.game.ReplayBoard;

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
