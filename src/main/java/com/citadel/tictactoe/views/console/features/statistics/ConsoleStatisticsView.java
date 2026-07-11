package com.citadel.tictactoe.views.console.features.statistics;

import com.citadel.tictactoe.controllers.features.statistics.StatisticsController;
import com.citadel.tictactoe.models.features.game.Player;
import com.citadel.tictactoe.shared.Terminal;
import com.citadel.tictactoe.views.console.core.ConsoleContext;
import com.citadel.tictactoe.views.core.StatisticsView;

public class ConsoleStatisticsView implements StatisticsView {

    private final ConsoleContext consoleContext;

    public ConsoleStatisticsView(ConsoleContext consoleContext) {
        this.consoleContext = consoleContext;
    }

    @Override
    public void interact(StatisticsController controller) {
        Terminal terminal = Terminal.getInstance();
        terminal.clear();
        for (int k = 0; k < 5; k++) {
            terminal.writeln();
        }
        terminal.writeln("  === ESTADÍSTICAS DE SESIÓN ===");
        terminal.writeln();
        terminal.writeln("  Partidas jugadas : " + controller.getTotalGames());
        terminal.writeln("  Victorias " + controller.getName(Player.XS) + " : " + controller.getWins(Player.XS));
        terminal.writeln("  Victorias " + controller.getName(Player.OS) + " : " + controller.getWins(Player.OS));
        terminal.writeln();
        terminal.writeln("  [1] Volver");
        terminal.writeln();
        consoleContext.limitedIntDialog().read("  Selecciona una opción", 1);
    }
}
