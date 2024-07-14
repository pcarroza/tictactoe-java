package main.controllers.errors;

import main.models.Game;

public enum ErrorGeneratorType {
    NOT_EMPTY(new NotEmptyErrorReportGenerator()),
    REPEATED_COORDINATE(new RepeatedCoordinateErrorReportGenerator()),
    NOT_PROPERTY(new NotPropertyErrorReportGenerator());

    private final ErrorReportGenerator errorReportGenerator;

    ErrorGeneratorType(ErrorReportGenerator errorReportGenerator) {
        this.errorReportGenerator = errorReportGenerator;
    }

    public ErrorReport getErrorReport(Game game) {
        return this.errorReportGenerator.getErrorReport(game);
    }
}
