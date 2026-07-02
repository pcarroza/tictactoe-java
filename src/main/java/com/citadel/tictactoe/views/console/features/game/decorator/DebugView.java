package com.citadel.tictactoe.views.console.features.game.decorator;

import com.citadel.tictactoe.controllers.features.game.GameOperationController;
import com.citadel.tictactoe.shared.Terminal;
import com.citadel.tictactoe.views.core.GameView;

public class DebugView extends ViewDecorator {

    public DebugView(GameView wrapped) {
        super(wrapped);
    }

    @Override
    protected void beforeVisit(GameOperationController operationController) {
        Terminal.getInstance().writeln("  [DEBUG] " + operationController.getClass().getSimpleName());
    }
}
