package com.citadel.tictactoe.controllers.features.replay.local;

import com.citadel.tictactoe.controllers.features.replay.ReplayController;
import com.citadel.tictactoe.models.features.game.Coordinate;
import com.citadel.tictactoe.models.features.game.MoveHistory;
import com.citadel.tictactoe.models.features.game.Player;

public class LocalReplayLogic {

    private ReplayState state;

    public LocalReplayLogic(MoveHistory history) {
        this.state = new ReplayStatesBuilder(history).getShowMoveState();
    }

    void next() {
        state = state.next();
    }

    void previous() {
        state = state.previous();
    }

    void exit() {
        state = state.exit();
    }

    Player getColor(Coordinate coordinate) {
        return state.getColor(coordinate);
    }

    int getPosition() {
        return state.getPosition();
    }

    int getTotal() {
        return state.getTotal();
    }

    boolean hasNext() {
        return state.hasNext();
    }

    boolean hasPrevious() {
        return state.hasPrevious();
    }
    
    public ReplayController getController() {
        return state.getController(this);
    }
}
