package com.citadel.tictactoe.views.console.features.game;

import com.citadel.tictactoe.controllers.features.game.UndoController;
import com.citadel.tictactoe.views.console.core.ConsoleContext;

class UndoView extends ConfirmMenuView<UndoController> {

    UndoView(ConsoleContext consoleContext) {
        super(consoleContext);
    }

    @Override
    String getTitle() {
        return "DESHACER MOVIMIENTO";
    }

    @Override
    String getConfirmLabel() {
        return "Confirmar deshacer";
    }

    @Override
    void confirm(UndoController controller) {
        controller.undo();
    }

    @Override
    void cancel(UndoController controller) {
        controller.cancel();
    }
}
