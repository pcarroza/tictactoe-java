package com.citadel.tictactoe.game;

import com.citadel.tictactoe.controllers.features.game.CoordinateController;
import com.citadel.tictactoe.controllers.features.game.MoveController;
import com.citadel.tictactoe.controllers.features.game.OperationControllerVisitor;
import com.citadel.tictactoe.controllers.features.game.PlacementControllerVisitor;
import com.citadel.tictactoe.controllers.features.game.PutController;
import com.citadel.tictactoe.controllers.features.game.errors.ErrorReport;
import com.citadel.tictactoe.controllers.features.game.errors.ErrorReportVisitor;
import com.citadel.tictactoe.controllers.features.game.local.TimedPlacementController;
import com.citadel.tictactoe.models.features.game.Coordinate;
import com.citadel.tictactoe.models.features.game.MoveHistory;
import com.citadel.tictactoe.models.features.game.Player;
import org.junit.Test;

import java.time.Duration;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.hamcrest.MatcherAssert.assertThat;

public class TimedPlacementControllerTest {

    private static final Coordinate ONLY_VALID_TARGET = new Coordinate(1, 1);

    @Test
    public void givenDeadlineInTheFuture_whenPut_thenChosenTargetIsForwardedUnchanged() {
        FakePutController fake = new FakePutController(ONLY_VALID_TARGET);
        TimedPlacementController timed = new TimedPlacementController(fake, Duration.ofSeconds(60));

        timed.put(ONLY_VALID_TARGET);

        assertThat(fake.getPlaced(), is(equalTo(ONLY_VALID_TARGET)));
    }

    @Test
    public void givenDeadlineAlreadyExpired_whenPut_thenChosenTargetIsReplacedByAValidFallback() {
        FakePutController fake = new FakePutController(ONLY_VALID_TARGET);
        TimedPlacementController timed = new TimedPlacementController(fake, Duration.ofSeconds(-1));

        timed.put(new Coordinate(3, 3));

        assertThat(fake.getPlaced(), is(equalTo(ONLY_VALID_TARGET)));
    }

    @Test
    public void givenTimedPlacementController_whenAccept_thenVisitorReceivesTheDecoratorItself() {
        FakePutController fake = new FakePutController(ONLY_VALID_TARGET);
        TimedPlacementController timed = new TimedPlacementController(fake, Duration.ofSeconds(60));
        CapturingVisitor visitor = new CapturingVisitor();

        timed.accept(visitor);

        assertThat(visitor.getCaptured(), is(sameInstance(timed)));
    }

    private static class CapturingVisitor implements PlacementControllerVisitor {

        private PutController captured;

        @Override
        public void visit(PutController putController) {
            captured = putController;
        }

        @Override
        public void visit(MoveController moveController) {
        }

        PutController getCaptured() {
            return captured;
        }
    }

    private static class FakePutController implements PutController {

        private static final ErrorReport INVALID = new ErrorReport(List.of()) {
            @Override
            public void accept(ErrorReportVisitor visitor) {
            }
        };

        private final Coordinate validTarget;

        private Coordinate placed;

        FakePutController(Coordinate validTarget) {
            this.validTarget = validTarget;
        }

        Coordinate getPlaced() {
            return placed;
        }

        @Override
        public Player take() {
            return Player.XS;
        }

        @Override
        public void put(Coordinate target) {
            placed = target;
        }

        @Override
        public boolean existTicTacToe() {
            return false;
        }

        @Override
        public CoordinateController getCoordinateController() {
            return null;
        }

        @Override
        public ErrorReport validateTarget(Coordinate target) {
            return target.equals(validTarget) ? null : INVALID;
        }

        @Override
        public void changeTurn() {
        }

        @Override
        public void end() {
        }

        @Override
        public void save() {
        }

        @Override
        public void exit() {
        }

        @Override
        public void undo() {
        }

        @Override
        public boolean canUndo() {
            return false;
        }

        @Override
        public void redo() {
        }

        @Override
        public boolean canRedo() {
            return false;
        }

        @Override
        public MoveHistory getMoveHistory() {
            return null;
        }

        @Override
        public Player getColor(Coordinate coordinate) {
            return Player.NONE;
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
}
