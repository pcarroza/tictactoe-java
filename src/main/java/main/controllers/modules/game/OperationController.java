package main.controllers.modules.game;

public interface OperationController {

    void accept(OperationControllerVisitor operationControllerVisitor);
}
