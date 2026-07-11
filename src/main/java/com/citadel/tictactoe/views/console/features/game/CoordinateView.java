package com.citadel.tictactoe.views.console.features.game;

import com.citadel.tictactoe.models.features.game.Coordinate;
import com.citadel.tictactoe.shared.LimitedIntDialog;
import com.citadel.tictactoe.shared.Terminal;

public class CoordinateView {

    private final LimitedIntDialog limitedIntDialog;

    public CoordinateView(LimitedIntDialog limitedIntDialog) {
        this.limitedIntDialog = limitedIntDialog;
    }

    public void write(String title, Coordinate coordinate) {
        assert title != null;
        assert coordinate != null;
        Terminal.getInstance().write(title + "[" + (coordinate.getRow()) + "," + (coordinate.getColumn()) + "]");
    }

    public void read(String title, Coordinate target) {
        assert title != null;
        assert target != null;
        target.setRow(limitedIntDialog.read("Fila?", Coordinate.DIMENSION));
        target.setColumn(limitedIntDialog.read("Columna?", Coordinate.DIMENSION));
    }
}
