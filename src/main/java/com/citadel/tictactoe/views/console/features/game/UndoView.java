package com.citadel.tictactoe.views.console.features.game;

import com.citadel.tictactoe.controllers.features.game.UndoController;

class UndoView extends ConfirmMenuView<UndoController> {

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
