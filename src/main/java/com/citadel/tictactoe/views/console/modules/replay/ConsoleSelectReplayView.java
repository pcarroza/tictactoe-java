package com.citadel.tictactoe.views.console.modules.replay;

import com.citadel.tictactoe.controllers.modules.replay.SelectReplayController;
import com.citadel.tictactoe.shared.LimitedIntDialog;
import com.citadel.tictactoe.shared.Terminal;
import com.citadel.tictactoe.views.core.SelectReplayView;

import java.util.List;

public class ConsoleSelectReplayView implements SelectReplayView {

    @Override
    public void interact(SelectReplayController controller) {
        controller.accept(this);
    }

    @Override
    public void visit(SelectReplayController controller) {
        Terminal terminal = Terminal.getInstance();
        terminal.clear();
        for (int k = 0; k < 5; k++) terminal.writeln();
        terminal.writeln("  === REPRODUCIR PARTIDA ===");
        terminal.writeln();
        if (!controller.hasGames()) {
            terminal.writeln("  No hay partidas para reproducir.");
            return;
        }
        List<String> titles = controller.getGameTitles();
        for (int i = 0; i < titles.size(); i++) {
            terminal.writeln("  [" + (i + 1) + "] " + titles.get(i));
        }
        terminal.writeln("  [" + (titles.size() + 1) + "] Volver");
        terminal.writeln();
        int option = new LimitedIntDialog().read("  Selecciona una partida", titles.size() + 1);
        if (option <= titles.size()) {
            controller.select(option - 1);
        }
    }
}
