package com.citadel.tictactoe.controllers.features.replay.local.logic;

import com.citadel.tictactoe.controllers.features.replay.ReplayController;
import com.citadel.tictactoe.controllers.features.replay.local.LocalReplayController;
import com.citadel.tictactoe.models.features.game.Coordinate;
import com.citadel.tictactoe.models.features.game.Player;
import com.citadel.tictactoe.models.features.game.ReplayBoard;

class ShowMoveReplayState extends ReplayState {

    private final ReplayBoard replayBoard;

    private final ExitReplayState exit;

    ShowMoveReplayState(ReplayBoard replayBoard, ExitReplayState exit) {
        this.replayBoard = replayBoard;
        this.exit = exit;
    }

    @Override
    ReplayController getController(LocalReplayLogic logic) {
        return new LocalReplayController(logic);
    }

    @Override
    ReplayState next() {
        replayBoard.next();
        return this;
    }

    @Override
    ReplayState previous() {
        replayBoard.previous();
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
        return replayBoard.getPosition();
    }

    @Override
    int getTotal() {
        return replayBoard.getTotal();
    }

    @Override
    boolean hasNext() {
        return replayBoard.hasNext();
    }

    @Override
    boolean hasPrevious() {
        return replayBoard.hasPrevious();
    }
}
