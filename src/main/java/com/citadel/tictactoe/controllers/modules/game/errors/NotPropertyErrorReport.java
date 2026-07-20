package com.citadel.tictactoe.controllers.modules.game.errors;

import com.citadel.tictactoe.models.modules.game.Coordinate;

import java.util.List;

public class NotPropertyErrorReport extends ErrorReport {

    public NotPropertyErrorReport(List<Coordinate> coordinates) {
        super(coordinates);
    }

    @Override
    public void accept(ErrorReportVisitor errorReportVisitor) {
        errorReportVisitor.visit(this);
    }
}
