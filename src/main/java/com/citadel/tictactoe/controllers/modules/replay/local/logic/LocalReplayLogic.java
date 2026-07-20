package com.citadel.tictactoe.controllers.modules.replay.local.logic;

import com.citadel.tictactoe.controllers.modules.replay.ReplayController;
import com.citadel.tictactoe.models.modules.game.MoveHistory;
import com.citadel.tictactoe.models.modules.game.ReplayBoard;
import com.citadel.tictactoe.models.modules.game.ReplayObserver;

public class LocalReplayLogic implements ReplayObserver {

    private ReplayState state;

    public LocalReplayLogic(MoveHistory history) {
        ReplayBoard replayBoard = new ReplayBoard(history, this);
        this.state = new ReplayStatesBuilder(replayBoard).getShowMoveState();
    }

    @Override
    public void exit() {
        state = state.exit();
    }

    public ReplayController getController() {
        return state.getController();
    }
}
