package main.controllers.local;

import main.controllers.OperationControllerVisitor;
import main.controllers.StartController;
import main.common.utils.ClosedInterval;
import main.models.Game;

public class LocalStartController extends LocalOperationController implements StartController {

    private final LocalOperationControllerBuilder localOperationControllerBuilder;

    public LocalStartController(Game game, LocalOperationControllerBuilder builder) {
        super(game);
        assert builder != null;
        localOperationControllerBuilder = builder;
    }

    public void start(int users) {
        assert new ClosedInterval<>(0, getNumberOfPlayers()).isIncluded(users);
        localOperationControllerBuilder.build(users);
        super.begin();
    }

    @Override
    public void accept(OperationControllerVisitor operationControllerVisitor) {
        operationControllerVisitor.visit(this);
    }
}
