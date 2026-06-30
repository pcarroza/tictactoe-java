package com.citadel.tictactoe.views.console.features.game;

import com.citadel.tictactoe.controllers.features.game.RedoController;

class RedoView extends ConfirmMenuView<RedoController> {

    @Override
    String getTitle() {
        return "REHACER MOVIMIENTO";
    }

    @Override
    String getConfirmLabel() {
        return "Confirmar rehacer";
    }

    @Override
    void confirm(RedoController controller) {
        controller.redo();
    }

    @Override
    void cancel(RedoController controller) {
        controller.cancel();
    }
}
