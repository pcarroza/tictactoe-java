package com.citadel.tictactoe.views.core;

import com.citadel.tictactoe.controllers.features.game.OperationController;
import com.citadel.tictactoe.controllers.features.game.OperationControllerVisitor;

public interface View extends OperationControllerVisitor {

    void interact(OperationController operationController);
}
