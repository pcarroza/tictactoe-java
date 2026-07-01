package com.citadel.tictactoe.controllers.features.game;

public interface GameOperationController {

    void accept(OperationControllerVisitor operationControllerVisitor);
}
