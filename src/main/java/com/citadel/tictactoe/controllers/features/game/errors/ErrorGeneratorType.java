package com.citadel.tictactoe.controllers.features.game.errors;

import com.citadel.tictactoe.models.features.game.Game;

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

    public static void main(String[] args) {
        ErrorGeneratorType.NOT_EMPTY.getErrorReport(null);
    }
}
