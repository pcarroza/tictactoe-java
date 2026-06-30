package com.citadel.tictactoe.views.console.features.game;

import com.citadel.tictactoe.shared.LimitedIntDialog;
import com.citadel.tictactoe.shared.Terminal;

abstract class ConfirmMenuView<T> {

    void interact(T controller) {
        showHeader();
        int option = LimitedIntDialog.instance().read("  Selecciona una opción", 2);
        if (option == 1) {
            confirm(controller);
        } else {
            cancel(controller);
        }
    }

    private void showHeader() {
        Terminal terminal = Terminal.getInstance();
        terminal.clear();
        for (int k = 0; k < 5; k++) {
            terminal.writeln();
        }
        terminal.writeln("  === " + getTitle() + " ===");
        terminal.writeln();
        terminal.writeln("  [1] " + getConfirmLabel());
        terminal.writeln("  [2] Cancelar");
        terminal.writeln();
    }

    abstract String getTitle();

    abstract String getConfirmLabel();

    abstract void confirm(T controller);

    abstract void cancel(T controller);
}
