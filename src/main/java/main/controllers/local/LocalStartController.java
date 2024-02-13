package main.controllers.local;

import main.controllers.OperationControllerVisitor;
import main.controllers.StartController;
import main.utils.ClosedInterval;
import main.models.Game;

public class LocalStartController extends LocalOperationController implements StartController {

    private final LocalOperationControllerBuilder localOperationControllerBuilder;

    public LocalStartController(Game game, LocalOperationControllerBuilder builder) {
        super(game);
        assert builder != null;
        this.localOperationControllerBuilder = builder;
    }

    public void start(int users) {
        assert new ClosedInterval<>(0, this.getNumberOfPlayers()).isIncluded(users);
        this.localOperationControllerBuilder.build(users);
        this.begin();
    }

    @Override
    public void accept(OperationControllerVisitor operationControllerVisitor) {
        operationControllerVisitor.visit(this);
    }
}
