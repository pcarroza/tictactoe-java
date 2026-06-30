package com.citadel.tictactoe.views.console.features.statistics;

import com.citadel.tictactoe.controllers.features.statistics.StatisticsController;
import com.citadel.tictactoe.models.features.game.Player;
import com.citadel.tictactoe.shared.LimitedIntDialog;
import com.citadel.tictactoe.shared.Terminal;
import com.citadel.tictactoe.views.core.StatisticsView;

public class ConsoleStatisticsView implements StatisticsView {

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
        terminal.writeln("  Victorias X      : " + controller.getWins(Player.XS));
        terminal.writeln("  Victorias O      : " + controller.getWins(Player.OS));
        terminal.writeln();
        terminal.writeln("  [1] Volver");
        terminal.writeln();
        LimitedIntDialog.instance().read("  Selecciona una opción", 1);
    }
}
