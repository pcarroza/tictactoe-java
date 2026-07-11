package com.citadel.tictactoe.views.console.features.game;

import com.citadel.tictactoe.controllers.features.game.PresenterController;
import com.citadel.tictactoe.models.features.game.Coordinate;
import com.citadel.tictactoe.shared.Terminal;
import com.citadel.tictactoe.views.console.core.ConsoleContext;

public class BoardView {

    private final ConsoleContext consoleContext;

    public BoardView(ConsoleContext consoleContext) {
        this.consoleContext = consoleContext;
    }

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
                consoleContext.colorView().writeCell(presenter.getColor(new Coordinate(i, j)));
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
