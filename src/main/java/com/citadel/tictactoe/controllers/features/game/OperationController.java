package com.citadel.tictactoe.controllers.features.game;

public interface OperationController {

    void accept(OperationControllerVisitor operationControllerVisitor);
}
