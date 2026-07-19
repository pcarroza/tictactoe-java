package com.citadel.tictactoe.controllers.features.replay.local;

import com.citadel.tictactoe.controllers.features.replay.ReplayController;
import com.citadel.tictactoe.controllers.features.replay.ReplayControllerVisitor;
import com.citadel.tictactoe.models.features.game.Coordinate;
import com.citadel.tictactoe.models.features.game.Player;
import com.citadel.tictactoe.models.features.game.ReplayBoard;

public class LocalReplayController implements ReplayController {

    private final ReplayBoard replayBoard;

    public LocalReplayController(ReplayBoard replayBoard) {
        this.replayBoard = replayBoard;
    }

    @Override
    public void accept(ReplayControllerVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public Player getColor(Coordinate coordinate) {
        return replayBoard.getColor(coordinate);
    }

    @Override
    public int getPosition() {
        return replayBoard.getPosition();
    }

    @Override
    public int getTotal() {
        return replayBoard.getTotal();
    }

    @Override
    public boolean hasNext() {
        return replayBoard.hasNext();
    }

    @Override
    public boolean hasPrevious() {
        return replayBoard.hasPrevious();
    }

    @Override
    public void next() {
        replayBoard.next();
    }

    @Override
    public void previous() {
        replayBoard.previous();
    }

    @Override
    public void exit() {
        replayBoard.exit();
    }
}
