package com.citadel.tictactoe.controllers.features.game.local;

import com.citadel.tictactoe.controllers.features.game.OperationControllerVisitor;
import com.citadel.tictactoe.controllers.features.game.PlacementControllerVisitor;
import com.citadel.tictactoe.controllers.features.game.PutController;
import com.citadel.tictactoe.models.features.game.Coordinate;

import java.time.Duration;
import java.time.Instant;

public class TimedPlacementController extends ForwardingPlacementController implements PutController {

    private final Instant deadline;

    public TimedPlacementController(PutController delegate, Duration limit) {
        super(delegate);
        this.deadline = Instant.now().plus(limit);
    }

    @Override
    public void put(Coordinate target) {
        delegate.put(Instant.now().isAfter(deadline) ? randomValidTarget() : target);
    }

    private Coordinate randomValidTarget() {
        Coordinate candidate = Coordinate.getCoordinateRandom();
        while (delegate.validateTarget(candidate) != null) {
            candidate = Coordinate.getCoordinateRandom();
        }
        return candidate;
    }

    @Override
    public void accept(PlacementControllerVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public void accept(OperationControllerVisitor visitor) {
        visitor.visit(this);
    }
}
