package com.citadel.tictactoe.controllers.modules.game.local.ai;

import com.citadel.tictactoe.models.modules.game.Coordinate;
import com.citadel.tictactoe.models.modules.game.Game;
import com.citadel.tictactoe.models.modules.game.Player;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

class MinimaxAiStrategy implements AiStrategy {

    private final Random random = new Random();

    @Override
    public Coordinate chooseTarget(Game game) {
        Search search = new Search(game, game.getPositions(), game.take());
        return bestMove(search, game.emptyCoordinates());
    }

    // El tablero no decrece nunca en la fase de deslizamiento (el número de fichas es constante),
    // así que un minimax sin cota no está garantizado a terminar. Aquí se usa una heurística de
    // una sola jugada (gana ya si puede) en vez de búsqueda completa.
    @Override
    public Coordinate chooseOrigin(Game game) {
        Player self = game.take();
        Set<Coordinate> owned = game.getPositions().get(self);
        for (Coordinate origin : game.playerCoordinates()) {
            if (hasWinningTargetFrom(game, owned, origin)) {
                return origin;
            }
        }
        return pickRandom(game.playerCoordinates());
    }

    @Override
    public Coordinate chooseMoveTarget(Game game, Coordinate origin) {
        Set<Coordinate> owned = game.getPositions().get(game.take());
        for (Coordinate target : game.emptyCoordinates()) {
            Set<Coordinate> afterMove = new HashSet<>(owned);
            afterMove.add(target);
            if (game.hasLine(afterMove)) {
                return target;
            }
        }
        return pickRandom(game.emptyCoordinates());
    }

    private boolean hasWinningTargetFrom(Game game, Set<Coordinate> owned, Coordinate origin) {
        for (Coordinate target : game.emptyCoordinates()) {
            Set<Coordinate> afterMove = new HashSet<>(owned);
            afterMove.remove(origin);
            afterMove.add(target);
            if (game.hasLine(afterMove)) {
                return true;
            }
        }
        return false;
    }

    private Coordinate bestMove(Search search, List<Coordinate> candidates) {
        Coordinate best = null;
        int bestScore = Integer.MIN_VALUE;
        for (Coordinate candidate : candidates) {
            int score = scoreCandidate(search, candidate);
            if (score > bestScore) {
                bestScore = score;
                best = candidate;
            }
        }
        return best;
    }

    private int scoreCandidate(Search search, Coordinate candidate) {
        search.positions().get(search.self()).add(candidate);
        int score = minimax(search, search.self().other(), 1);
        search.positions().get(search.self()).remove(candidate);
        return score;
    }

    private int minimax(Search search, Player toMove, int depth) {
        if (search.game().hasLine(search.positions().get(search.self()))) {
            return 10 - depth;
        }
        if (search.game().hasLine(search.positions().get(search.self().other()))) {
            return depth - 10;
        }
        if (search.game().isFull(search.positions())) {
            return 0;
        }
        return toMove == search.self() ? maximize(search, toMove, depth) : minimize(search, toMove, depth);
    }

    private int maximize(Search search, Player toMove, int depth) {
        int best = Integer.MIN_VALUE;
        for (Coordinate candidate : emptyCells(search.positions())) {
            search.positions().get(toMove).add(candidate);
            best = Math.max(best, minimax(search, toMove.other(), depth + 1));
            search.positions().get(toMove).remove(candidate);
        }
        return best;
    }

    private int minimize(Search search, Player toMove, int depth) {
        int best = Integer.MAX_VALUE;
        for (Coordinate candidate : emptyCells(search.positions())) {
            search.positions().get(toMove).add(candidate);
            best = Math.min(best, minimax(search, toMove.other(), depth + 1));
            search.positions().get(toMove).remove(candidate);
        }
        return best;
    }

    private List<Coordinate> emptyCells(Map<Player, Set<Coordinate>> positions) {
        Set<Coordinate> occupied = new HashSet<>();
        positions.values().forEach(occupied::addAll);
        List<Coordinate> empty = new ArrayList<>();
        for (int row = 1; row <= Coordinate.DIMENSION; row++) {
            for (int column = 1; column <= Coordinate.DIMENSION; column++) {
                addIfEmpty(empty, occupied, new Coordinate(row, column));
            }
        }
        return empty;
    }

    private void addIfEmpty(List<Coordinate> empty, Set<Coordinate> occupied, Coordinate candidate) {
        if (!occupied.contains(candidate)) {
            empty.add(candidate);
        }
    }

    private Coordinate pickRandom(List<Coordinate> options) {
        assert !options.isEmpty();
        return options.get(random.nextInt(options.size()));
    }

    private record Search(Game game, Map<Player, Set<Coordinate>> positions, Player self) {
    }
}
