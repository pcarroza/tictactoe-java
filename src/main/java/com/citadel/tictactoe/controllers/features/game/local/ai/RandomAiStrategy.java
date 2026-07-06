package com.citadel.tictactoe.controllers.features.game.local.ai;

import com.citadel.tictactoe.models.features.game.Coordinate;
import com.citadel.tictactoe.models.features.game.Game;

import java.util.List;
import java.util.Random;

class RandomAiStrategy implements AiStrategy {

    private final Random random = new Random();

    @Override
    public Coordinate chooseTarget(Game game) {
        return pickRandom(game.emptyCoordinates());
    }

    @Override
    public Coordinate chooseOrigin(Game game) {
        return pickRandom(game.playerCoordinates());
    }

    @Override
    public Coordinate chooseMoveTarget(Game game, Coordinate origin) {
        return pickRandom(game.emptyCoordinates());
    }

    private Coordinate pickRandom(List<Coordinate> options) {
        assert !options.isEmpty();
        return options.get(random.nextInt(options.size()));
    }
}
