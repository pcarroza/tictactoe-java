package com.citadel.tictactoe.views.console.features.load;

import com.citadel.tictactoe.controllers.features.load.LoadController;
import com.citadel.tictactoe.shared.LimitedIntDialog;
import com.citadel.tictactoe.shared.Terminal;
import com.citadel.tictactoe.views.core.LoadView;

import java.util.List;

public class ConsoleLoadView implements LoadView {

    @Override
    public void interact(LoadController controller) {
        controller.accept(this);
    }

    @Override
    public void visit(LoadController controller) {
        Terminal terminal = Terminal.getInstance();
        terminal.clear();
        for (int k = 0; k < 5; k++) terminal.writeln();
        terminal.writeln("  === CARGAR PARTIDA ===");
        terminal.writeln();
        if (!controller.hasGames()) {
            terminal.writeln("  No hay partidas guardadas.");
            return;
        }
        List<String> titles = controller.getGameTitles();
        for (int i = 0; i < titles.size(); i++) {
            terminal.writeln("  [" + (i + 1) + "] " + titles.get(i));
        }
        terminal.writeln();
        int option = LimitedIntDialog.instance().read("  Selecciona una partida", titles.size());
        controller.select(option - 1);
    }
}
