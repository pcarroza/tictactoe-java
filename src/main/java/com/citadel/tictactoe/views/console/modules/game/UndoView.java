package com.citadel.tictactoe.views.console.modules.game;

import com.citadel.tictactoe.controllers.modules.game.UndoController;

class UndoView extends ConfirmMenuView<UndoController> {

    UndoView() {
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
