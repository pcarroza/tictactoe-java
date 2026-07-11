package com.citadel.tictactoe.views.console.features.game;

import com.citadel.tictactoe.controllers.features.game.SaveController;
import com.citadel.tictactoe.shared.Terminal;
import com.citadel.tictactoe.views.console.core.ConsoleContext;

public class SaveView {

    private final ConsoleContext consoleContext;

    public SaveView(ConsoleContext consoleContext) {
        this.consoleContext = consoleContext;
    }

    public void interact(SaveController saveController) {
        Terminal terminal = Terminal.getInstance();
        terminal.clear();
        for (int k = 0; k < 5; k++) {
            terminal.writeln();
        }
        terminal.writeln("  === GUARDAR PARTIDA ===");
        terminal.writeln();
        terminal.writeln("  [1] Guardar y continuar");
        terminal.writeln("  [2] Guardar y salir");
        terminal.writeln("  [3] Salir sin guardar");
        terminal.writeln();
        int option = consoleContext.limitedIntDialog().read("  Selecciona una opción", 3);
        if (option == 1) {
            saveController.save();
            saveController.resume();
        } else if (option == 2) {
            saveController.save();
            saveController.exit();
        } else {
            saveController.exit();
        }
    }
}
