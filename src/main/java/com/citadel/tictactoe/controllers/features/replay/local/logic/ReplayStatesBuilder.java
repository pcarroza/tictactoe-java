package com.citadel.tictactoe.controllers.features.replay.local.logic;

import com.citadel.tictactoe.models.features.game.MoveHistory;
import com.citadel.tictactoe.models.features.game.MoveRecord;
import com.citadel.tictactoe.models.features.game.ReplayBoard;

import java.util.ArrayList;
import java.util.List;

class ReplayStatesBuilder {

    private final ShowMoveReplayState showMoveState;

    ReplayStatesBuilder(MoveHistory history) {
        ExitReplayState exit = new ExitReplayState();
        ReplayBoard replayBoard = new ReplayBoard(collectRecords(history));
        showMoveState = new ShowMoveReplayState(replayBoard, exit);
    }

    private List<MoveRecord> collectRecords(Iterable<MoveRecord> history) {
        List<MoveRecord> list = new ArrayList<>();
        for (MoveRecord record : history) {
            list.add(record);
        }
        return list;
    }

    ShowMoveReplayState getShowMoveState() {
        return showMoveState;
    }
}
