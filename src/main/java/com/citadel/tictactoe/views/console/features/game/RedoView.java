package com.citadel.tictactoe.views.console.features.game;

import com.citadel.tictactoe.controllers.features.game.RedoController;
import com.citadel.tictactoe.shared.LimitedIntDialog;
import com.citadel.tictactoe.shared.Terminal;

public class RedoView {

    public void interact(RedoController redoController) {
        Terminal terminal = Terminal.getInstance();
        terminal.clear();
        for (int k = 0; k < 5; k++) terminal.writeln();
        terminal.writeln("  === REHACER MOVIMIENTO ===");
        terminal.writeln();
        terminal.writeln("  [1] Confirmar rehacer");
        terminal.writeln("  [2] Cancelar");
        terminal.writeln();
        int option = LimitedIntDialog.instance().read("  Selecciona una opción", 2);
        if (option == 1) {
            redoController.redo();
        } else {
            redoController.cancel();
        }
    }

}
