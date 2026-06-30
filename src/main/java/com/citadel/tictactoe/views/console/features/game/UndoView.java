package com.citadel.tictactoe.views.console.features.game;

import com.citadel.tictactoe.controllers.features.game.UndoController;
import com.citadel.tictactoe.shared.LimitedIntDialog;
import com.citadel.tictactoe.shared.Terminal;

public class UndoView {

    public void interact(UndoController undoController) {
        Terminal terminal = Terminal.getInstance();
        terminal.clear();
        for (int k = 0; k < 5; k++) terminal.writeln();
        terminal.writeln("  === DESHACER MOVIMIENTO ===");
        terminal.writeln();
        terminal.writeln("  [1] Confirmar deshacer");
        terminal.writeln("  [2] Cancelar");
        terminal.writeln();
        int option = LimitedIntDialog.instance().read("  Selecciona una opción", 2);
        if (option == 1) {
            undoController.undo();
        } else {
            undoController.cancel();
        }
    }

}
