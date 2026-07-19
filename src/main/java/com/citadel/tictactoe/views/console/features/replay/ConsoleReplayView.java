package com.citadel.tictactoe.views.console.features.replay;

import com.citadel.tictactoe.controllers.features.replay.ReplayController;
import com.citadel.tictactoe.models.features.game.Coordinate;
import com.citadel.tictactoe.models.features.game.Player;
import com.citadel.tictactoe.shared.LimitedIntDialog;
import com.citadel.tictactoe.shared.Terminal;
import com.citadel.tictactoe.views.core.ReplayView;

import java.util.ArrayList;
import java.util.List;

public class ConsoleReplayView implements ReplayView {

    @Override
    public void interact(ReplayController controller) {
        controller.accept(this);
    }

    @Override
    public void visit(ReplayController controller) {
        Terminal terminal = Terminal.getInstance();
        terminal.clear();
        showHeader(terminal, controller);
        showBoard(terminal, controller);
        List<Runnable> options = buildOptions(terminal, controller);
        int choice = new LimitedIntDialog().read("  Selecciona una opción", options.size());
        options.get(choice - 1).run();
    }

    private void showHeader(Terminal terminal, ReplayController controller) {
        terminal.writeln();
        terminal.writeln(
                "  === REPLAY — Movimiento " + controller.getPosition() + " de " + controller.getTotal() + " ===");
        terminal.writeln();
    }

    private void showBoard(Terminal terminal, ReplayController controller) {
        terminal.writeln("      1   2   3  ");
        terminal.writeln("    ┌───┬───┬───┐");
        for (int i = 1; i <= 3; i++) {
            terminal.write("  " + i + " │");
            for (int j = 1; j <= 3; j++) {
                terminal.write(cellOf(controller.getColor(new Coordinate(i, j))));
                terminal.write("│");
            }
            terminal.writeln();
            if (i < 3) {
                terminal.writeln("    ├───┼───┼───┤");
            }
        }
        terminal.writeln("    └───┴───┴───┘");
    }

    private String cellOf(Player player) {
        if (player == Player.OS)
            return "\033[33m X \033[0m";
        if (player == Player.XS)
            return "\033[34m O \033[0m";
        return "\033[90m · \033[0m";
    }

    private List<Runnable> buildOptions(Terminal terminal, ReplayController controller) {
        List<Runnable> options = new ArrayList<>();
        if (controller.hasNext()) {
            addOption(terminal, options, "Siguiente", controller::next);
        }
        if (controller.hasPrevious()) {
            addOption(terminal, options, "Anterior", controller::previous);
        }
        addOption(terminal, options, "Salir", controller::exit);
        return options;
    }

    private void addOption(Terminal terminal, List<Runnable> options, String label, Runnable action) {
        options.add(action);
        terminal.writeln("  [" + options.size() + "] " + label);
    }
}
