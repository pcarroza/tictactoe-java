package com.citadel.tictactoe.views.core;

import com.citadel.tictactoe.controllers.features.game.GameOperationController;
import com.citadel.tictactoe.controllers.features.game.OperationControllerVisitor;

public interface View extends OperationControllerVisitor {

    void interact(GameOperationController operationController);
}
