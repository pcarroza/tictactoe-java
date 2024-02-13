package main.controllers.errors;

import main.models.Game;

public class NotEmptyErrorReportGenerator extends ErrorReportGenerator {

    @Override
    public ErrorReport getErrorReport(Game game) {
        return new RepeatedCoordinateErrorReport(game.emptyCoordinates());
    }
}
