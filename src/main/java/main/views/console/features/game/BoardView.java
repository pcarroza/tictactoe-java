package main.views.console.features.game;

import main.controllers.features.game.PresenterController;
import main.models.features.game.Coordinate;
import main.shared.Terminal;

public class BoardView {

    void write(PresenterController presenter) {
        assert presenter != null;
        Terminal terminal = Terminal.getInstance();
        for (int k = 0; k < 5; k++) terminal.writeln();
        terminal.writeln("      1   2   3  ");
        terminal.writeln("    ┌───┬───┬───┐");
        for (int i = 1; i <= Coordinate.DIMENSION; i++) {
            terminal.write("  " + i + " │");
            for (int j = 1; j <= Coordinate.DIMENSION; j++) {
                ColorView.instance().writeCell(presenter.getColor(new Coordinate(i, j)));
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
