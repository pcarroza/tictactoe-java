package com.citadel.tictactoe.controllers.features.game.local.logic;

import com.citadel.tictactoe.controllers.features.game.CoordinateController;
import com.citadel.tictactoe.controllers.features.game.GameOperationController;
import com.citadel.tictactoe.controllers.features.game.MoveController;
import com.citadel.tictactoe.controllers.features.game.OperationControllerVisitor;
import com.citadel.tictactoe.controllers.features.game.PlacementControllerVisitor;
import com.citadel.tictactoe.controllers.features.game.PutController;
import com.citadel.tictactoe.controllers.features.game.errors.ErrorReport;
import com.citadel.tictactoe.controllers.features.game.local.TimedPlacementController;
import com.citadel.tictactoe.models.features.game.Coordinate;
import com.citadel.tictactoe.models.features.game.MoveHistory;
import com.citadel.tictactoe.models.features.game.Player;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.CoreMatchers.sameInstance;
import static org.hamcrest.MatcherAssert.assertThat;

public class TimedControllerFactoryTest {

    @Test
    public void givenNullController_whenWrap_thenResultIsNull() {
        assertThat(TimedControllerFactory.wrap(null), is(nullValue()));
    }

    @Test
    public void givenPutController_whenWrap_thenResultIsTimedPlacementController() {
        GameOperationController wrapped = TimedControllerFactory.wrap(new FakePutController());
        assertThat(wrapped, is(instanceOf(TimedPlacementController.class)));
    }

    @Test
    public void givenMoveController_whenWrap_thenResultIsTheSameInstanceUnwrapped() {
        FakeMoveController move = new FakeMoveController();
        GameOperationController wrapped = TimedControllerFactory.wrap(move);
        assertThat(wrapped, is(sameInstance(move)));
    }

    private static class FakePutController implements PutController {

        @Override
        public Player take() {
            return Player.XS;
        }

        @Override
        public void put(Coordinate target) {
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
            return null;
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

    private static class FakeMoveController implements MoveController {

        @Override
        public void remove(Coordinate origin) {
        }

        @Override
        public ErrorReport validateOrigin(Coordinate origin) {
            return null;
        }

        @Override
        public ErrorReport validateTarget(Coordinate origin, Coordinate target) {
            return null;
        }

        @Override
        public Player take() {
            return Player.OS;
        }

        @Override
        public void put(Coordinate target) {
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
            return null;
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
