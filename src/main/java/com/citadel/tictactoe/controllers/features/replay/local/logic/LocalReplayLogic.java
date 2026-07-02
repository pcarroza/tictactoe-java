package com.citadel.tictactoe.controllers.features.replay.local.logic;

import com.citadel.tictactoe.controllers.features.replay.ReplayController;
import com.citadel.tictactoe.models.features.game.Coordinate;
import com.citadel.tictactoe.models.features.game.MoveHistory;
import com.citadel.tictactoe.models.features.game.Player;

public class LocalReplayLogic {

    private ReplayState state;

    public LocalReplayLogic(MoveHistory history) {
        this.state = new ReplayStatesBuilder(history).getShowMoveState();
    }

    public void next() {
        state = state.next();
    }

    public void previous() {
        state = state.previous();
    }

    public void exit() {
        state = state.exit();
    }

    public Player getColor(Coordinate coordinate) {
        return state.getColor(coordinate);
    }

    public int getPosition() {
        return state.getPosition();
    }

    public int getTotal() {
        return state.getTotal();
    }

    public boolean hasNext() {
        return state.hasNext();
    }

    public boolean hasPrevious() {
        return state.hasPrevious();
    }
    
    public ReplayController getController() {
        return state.getController(this);
    }
}
