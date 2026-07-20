package com.citadel.tictactoe.views.console.modules.game;

import com.citadel.tictactoe.controllers.modules.game.RedoController;

class RedoView extends ConfirmMenuView<RedoController> {

    RedoView() {
    }

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
