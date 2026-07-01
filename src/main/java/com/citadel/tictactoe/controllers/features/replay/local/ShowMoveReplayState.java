package com.citadel.tictactoe.controllers.features.replay.local;

import com.citadel.tictactoe.controllers.features.replay.ReplayController;
import com.citadel.tictactoe.models.features.game.Coordinate;
import com.citadel.tictactoe.models.features.game.MoveRecord;
import com.citadel.tictactoe.models.features.game.Player;

import java.util.List;

class ShowMoveReplayState extends ReplayState {

    private final ReplayBoard replayBoard;

    private final List<MoveRecord> records;

    private int position;

    private final ExitReplayState exit;

    ShowMoveReplayState(List<MoveRecord> records, ExitReplayState exit) {
        this.replayBoard = new ReplayBoard();
        this.records = records;
        this.position = 0;
        this.exit = exit;
    }

    @Override
    ReplayController getController(LocalReplayLogic logic) {
        return new LocalReplayController(logic);
    }

    @Override
    ReplayState next() {
        replayBoard.apply(records.get(position++));
        return this;
    }

    @Override
    ReplayState previous() {
        replayBoard.reverse(records.get(--position));
        return this;
    }

    @Override
    ReplayState exit() {
        return exit;
    }

    @Override
    Player getColor(Coordinate coordinate) {
        return replayBoard.getColor(coordinate);
    }

    @Override
    int getPosition() {
        return position;
    }

    @Override
    int getTotal() {
        return records.size();
    }

    @Override
    boolean hasNext() {
        return position < records.size();
    }

    @Override
    boolean hasPrevious() {
        return position > 0;
    }

}
