package com.citadel.tictactoe.controllers.features.game.errors;

import com.citadel.tictactoe.models.features.game.Coordinate;

import java.util.List;

public class RepeatedCoordinateErrorReport extends ErrorReport {

    public RepeatedCoordinateErrorReport(List<Coordinate> coordinates) {
        super(coordinates);
    }

    @Override
    public void accept(ErrorReportVisitor errorReportVisitor) {
        errorReportVisitor.visit(this);
    }
}


