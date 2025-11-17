package main.controllers.modules.game.errors;

import main.models.modules.game.Coordinate;

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
