package com.citadel.tictactoe.views.console.features.game.decorator;

import com.citadel.tictactoe.controllers.features.game.GameOperationController;
import com.citadel.tictactoe.shared.Terminal;
import com.citadel.tictactoe.views.core.GameView;

import java.time.LocalTime;

public class TimestampedView extends ViewDecorator {

    public TimestampedView(GameView wrapped) {
        super(wrapped);
    }

    @Override
    protected void beforeVisit(GameOperationController operationController) {
        Terminal.getInstance().writeln("  [" + LocalTime.now() + "]");
    }
}
