package com.citadel.tictactoe.controllers.modules.game;

public interface GameOperationController {

    void accept(OperationControllerVisitor operationControllerVisitor);
}
