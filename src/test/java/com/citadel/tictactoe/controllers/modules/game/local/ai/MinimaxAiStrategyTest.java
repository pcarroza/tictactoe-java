package com.citadel.tictactoe.controllers.modules.game.local.ai;

import com.citadel.tictactoe.models.modules.game.Coordinate;
import com.citadel.tictactoe.models.modules.game.Game;
import com.citadel.tictactoe.models.modules.game.GameSnapshot;
import com.citadel.tictactoe.models.modules.game.MoveHistory;
import com.citadel.tictactoe.models.modules.game.Observer;
import com.citadel.tictactoe.models.modules.game.Player;
import org.junit.Test;

import java.util.EnumMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class MinimaxAiStrategyTest {

    private final AiStrategy strategy = AiDifficulty.HARD.createStrategy();

    @Test
    public void givenImmediateWinAvailable_whenChooseTarget_thenTakesIt() {
        Game game = restoredGame(coordinates(1, 1, 1, 2), coordinates(2, 1), 0);

        Coordinate target = strategy.chooseTarget(game);

        assertThat(target, is(equalTo(new Coordinate(1, 3))));
    }

    @Test
    public void givenOpponentThreatensWin_whenChooseTarget_thenBlocks() {
        Game game = restoredGame(coordinates(1, 1, 1, 2), coordinates(2, 2), 1);

        Coordinate target = strategy.chooseTarget(game);

        assertThat(target, is(equalTo(new Coordinate(1, 3))));
    }

    @Test
    public void givenWinningSlideAvailable_whenChooseOriginAndTarget_thenCompletesTheLine() {
        Set<Coordinate> os = coordinates(1, 1, 2, 1, 3, 3);
        Set<Coordinate> xs = coordinates(1, 2, 2, 3, 3, 1);
        Game game = restoredGame(os, xs, 0);

        Coordinate origin = strategy.chooseOrigin(game);
        Coordinate target = strategy.chooseMoveTarget(game, origin);

        assertThat(origin, is(equalTo(new Coordinate(2, 1))));
        assertThat(target, is(equalTo(new Coordinate(2, 2))));
    }

    private Game restoredGame(Set<Coordinate> os, Set<Coordinate> xs, int currentPlayerIndex) {
        Map<Player, Set<Coordinate>> positions = new EnumMap<>(Player.class);
        positions.put(Player.OS, os);
        positions.put(Player.XS, xs);
        GameSnapshot snapshot = new GameSnapshot(positions, currentPlayerIndex, 2, 1, new MoveHistory());
        Game game = new Game(new NoOpObserver());
        game.restore(snapshot);
        return game;
    }

    private Set<Coordinate> coordinates(int... rowColumnPairs) {
        Set<Coordinate> coordinates = new HashSet<>();
        for (int i = 0; i < rowColumnPairs.length; i += 2) {
            coordinates.add(new Coordinate(rowColumnPairs[i], rowColumnPairs[i + 1]));
        }
        return coordinates;
    }

    private static class NoOpObserver implements Observer {

        @Override
        public void initialize() {
        }

        @Override
        public void begin() {
        }

        @Override
        public void end() {
        }

        @Override
        public void exit() {
        }

        @Override
        public void save() {
        }

        @Override
        public void resume() {
        }

        @Override
        public void undo() {
        }

        @Override
        public void redo() {
        }
    }
}
