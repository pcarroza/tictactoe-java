package com.citadel.tictactoe.views.console.modules.game;

import com.citadel.tictactoe.controllers.modules.game.PresenterController;
import com.citadel.tictactoe.models.modules.game.Coordinate;
import com.citadel.tictactoe.shared.Terminal;

public class BoardView {

    void write(PresenterController presenter) {
        assert presenter != null;
        Terminal terminal = Terminal.getInstance();
        for (int k = 0; k < 5; k++) {
            terminal.writeln();
        }
        terminal.writeln("      1   2   3  ");
        terminal.writeln("    ┌───┬───┬───┐");
        for (int i = 1; i <= Coordinate.DIMENSION; i++) {
            terminal.write("  " + i + " │");
            for (int j = 1; j <= Coordinate.DIMENSION; j++) {
                new ColorView().writeCell(presenter.getColor(new Coordinate(i, j)));
                terminal.write("│");
            }
            terminal.writeln();
            if (i < Coordinate.DIMENSION) {
                terminal.writeln("    ├───┼───┼───┤");
            }
        }
        terminal.writeln("    └───┴───┴───┘");
    }
}
