package main.controllers.errors;

import main.models.Coordinate;

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
