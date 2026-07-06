package com.citadel.tictactoe.controllers.features.game.local;

import com.citadel.tictactoe.controllers.features.game.CoordinateControllerVisitor;
import com.citadel.tictactoe.controllers.features.game.MachineCoordinateController;
import com.citadel.tictactoe.controllers.features.game.local.ai.AiStrategy;
import com.citadel.tictactoe.models.features.game.Coordinate;
import com.citadel.tictactoe.models.features.game.Game;

public class LocalAiCoordinateController extends LocalCoordinateController
    implements MachineCoordinateController {

    private final AiStrategy strategy;

    public LocalAiCoordinateController(Game game, AiStrategy strategy) {
        super(game);
        assert strategy != null;
        this.strategy = strategy;
    }

    @Override
    public Coordinate getOrigin() {
        return strategy.chooseOrigin(getGame());
    }

    @Override
    public Coordinate getTarget() {
        return strategy.chooseTarget(getGame());
    }

    @Override
    public Coordinate getTarget(Coordinate origin) {
        assert origin != null;
        return strategy.chooseMoveTarget(getGame(), origin);
    }

    @Override
    public void accept(CoordinateControllerVisitor coordinateControllerVisitor) {
        coordinateControllerVisitor.visit(this);
    }
}
