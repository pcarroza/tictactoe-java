package com.citadel.tictactoe.views.console.modules.game.decorator;

import com.citadel.tictactoe.controllers.modules.game.PlacementController;
import com.citadel.tictactoe.shared.Terminal;
import com.citadel.tictactoe.views.core.GameView;

public class TurnNumberedView extends ViewDecorator {

    public TurnNumberedView(GameView wrapped) {
        super(wrapped);
    }

    @Override
    public void visit(PlacementController placementController) {
        Terminal.getInstance().writeln("  Turno " + (placementController.getMoveHistory().size() + 1));
        super.visit(placementController);
    }
}
