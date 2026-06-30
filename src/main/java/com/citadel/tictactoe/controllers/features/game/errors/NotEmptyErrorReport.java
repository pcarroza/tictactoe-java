package com.citadel.tictactoe.controllers.features.game.errors;

import com.citadel.tictactoe.models.features.game.Coordinate;

import java.util.List;

public class NotEmptyErrorReport extends ErrorReport {

    public NotEmptyErrorReport(List<Coordinate> coordinates) {
        super(coordinates);
    }

    @Override
    public void accept(ErrorReportVisitor errorReportVisitor) {
        errorReportVisitor.visit(this);
    }
}
