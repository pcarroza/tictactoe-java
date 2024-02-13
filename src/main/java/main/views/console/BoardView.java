package main.views.console;

import main.controllers.PresenterController;
import main.models.Coordinate;
import main.utils.Terminal;

import java.util.stream.IntStream;

public class BoardView {

    void write(PresenterController presenter) {
        assert presenter != null;
        for (int i = 1; i <= Coordinate.DIMENSION; i++) {
            for (int j = 1; j <= Coordinate.DIMENSION; j++) {
                ColorView.instance().write(" ", presenter.getColor(new Coordinate(i, j)));
            }
            Terminal.getInstance().writeln();
        }
    }
}
