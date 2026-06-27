package main.controllers.features.game;

public interface OperationController {

    void accept(OperationControllerVisitor operationControllerVisitor);
}
