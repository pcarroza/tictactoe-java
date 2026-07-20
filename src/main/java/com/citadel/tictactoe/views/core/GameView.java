package com.citadel.tictactoe.views.core;

import com.citadel.tictactoe.controllers.modules.game.GameOperationController;
import com.citadel.tictactoe.controllers.modules.game.OperationControllerVisitor;

public interface GameView extends OperationControllerVisitor {

    void interact(GameOperationController operationController);
}
