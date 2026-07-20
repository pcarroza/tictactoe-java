package com.citadel.tictactoe.controllers.modules.game.errors;

import com.citadel.tictactoe.models.modules.game.Coordinate;

import java.util.Iterator;
import java.util.List;

public abstract class ErrorReport {

    private final List<Coordinate> coordinates;

    protected ErrorReport(List<Coordinate> coordinates) {
        this.coordinates = coordinates;
    }

    public Iterator<Coordinate> iterator() {
        return this.coordinates.iterator();
    }

    public abstract void accept(ErrorReportVisitor errorReportVisitor);
}
