package com.citadel.tictactoe.views.console.features.game;

import com.citadel.tictactoe.models.features.game.MoveHistory;
import com.citadel.tictactoe.models.features.game.MoveRecord;
import com.citadel.tictactoe.models.features.game.MoveType;
import com.citadel.tictactoe.shared.LimitedIntDialog;
import com.citadel.tictactoe.shared.Terminal;

class HistoryView {

    void show(MoveHistory history) {
        Terminal terminal = Terminal.getInstance();
        terminal.clear();
        for (int k = 0; k < 3; k++) terminal.writeln();
        terminal.writeln("  === HISTORIAL DE MOVIMIENTOS ===");
        terminal.writeln();
        if (history.size() == 0) {
            terminal.writeln("  Aún no se han realizado movimientos.");
        } else {
            for (MoveRecord record : history) {
                terminal.writeln(format(record));
            }
        }
        terminal.writeln();
        terminal.writeln("  [1] Volver");
        terminal.writeln();
        LimitedIntDialog.instance().read("  Selecciona una opción", 1);
    }

    private String format(MoveRecord record) {
        String action = record.type() == MoveType.PUT ? "pone en" : "retira de";
        String player = record.player().name();
        String coord = "[" + record.coordinate().getRow() + "," + record.coordinate().getColumn() + "]";
        return "  " + record.turn() + ". " + player + " " + action + " " + coord;
    }
}
