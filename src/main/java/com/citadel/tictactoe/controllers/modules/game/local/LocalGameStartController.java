package com.citadel.tictactoe.controllers.modules.game.local;

import com.citadel.tictactoe.controllers.modules.game.OperationControllerVisitor;
import com.citadel.tictactoe.controllers.modules.game.StartController;
import com.citadel.tictactoe.controllers.modules.game.local.ai.AiDifficulty;
import com.citadel.tictactoe.controllers.modules.game.local.builders.LocalOperationControllerBuilder;
import com.citadel.tictactoe.models.modules.game.Game;
import com.citadel.tictactoe.shared.ClosedInterval;

public class LocalGameStartController extends LocalGameOperationController implements StartController {

    private final LocalOperationControllerBuilder localOperationControllerBuilder;

    public LocalGameStartController(Game game, LocalOperationControllerBuilder builder) {
        super(game);
        assert builder != null;
        localOperationControllerBuilder = builder;
    }

    public void start(int users, AiDifficulty difficulty) {
        assert new ClosedInterval<>(0, getNumberOfPlayers()).isIncluded(users);
        localOperationControllerBuilder.build(users, difficulty);
        super.begin();
    }

    @Override
    public void accept(OperationControllerVisitor operationControllerVisitor) {
        operationControllerVisitor.visit(this);
    }
}
