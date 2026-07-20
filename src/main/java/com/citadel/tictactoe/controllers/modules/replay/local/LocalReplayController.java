package com.citadel.tictactoe.controllers.modules.replay.local;

import com.citadel.tictactoe.controllers.modules.replay.ReplayController;
import com.citadel.tictactoe.controllers.modules.replay.ReplayControllerVisitor;
import com.citadel.tictactoe.models.modules.game.Coordinate;
import com.citadel.tictactoe.models.modules.game.Player;
import com.citadel.tictactoe.models.modules.game.ReplayBoard;

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
