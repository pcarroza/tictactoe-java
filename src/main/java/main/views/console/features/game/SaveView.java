package main.views.console.features.game;

import main.controllers.features.game.SaveController;
import main.shared.LimitedIntDialog;
import main.shared.Terminal;

public class SaveView {

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
        int option = LimitedIntDialog.instance().read("  Selecciona una opción", 3);
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
