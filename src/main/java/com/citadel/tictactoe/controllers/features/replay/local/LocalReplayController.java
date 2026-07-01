package com.citadel.tictactoe.controllers.features.replay.local;

import com.citadel.tictactoe.controllers.features.replay.ReplayController;
import com.citadel.tictactoe.controllers.features.replay.ReplayControllerVisitor;
import com.citadel.tictactoe.models.features.game.Coordinate;
import com.citadel.tictactoe.models.features.game.Player;

public class LocalReplayController implements ReplayController {

    private final LocalReplayLogic logic;

    LocalReplayController(LocalReplayLogic logic) {
        this.logic = logic;
    }

    @Override
    public void accept(ReplayControllerVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public Player getColor(Coordinate coordiante) {
        return logic.getColor(coordiante);
    }

    @Override
    public int getPosition() {
        return logic.getPosition();
    }

    @Override
    public int getTotal() {
        return logic.getTotal();
    }

    @Override
    public boolean hasNext() {
        return logic.hasNext();
    }

    @Override
    public boolean hasPrevious() {
        return logic.hasPrevious();
    }

    @Override
    public void next() {
        logic.next();
    }

    @Override
    public void previous() {
        logic.previous();
    }

    @Override
    public void exit() {
        logic.exit();
    }
}
