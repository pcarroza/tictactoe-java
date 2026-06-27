package main.controllers.features.game.errors;

import main.models.features.game.Game;

public class RepeatedCoordinateErrorReportGenerator extends ErrorReportGenerator {

    @Override
    public ErrorReport getErrorReport(Game game) {
        return new RepeatedCoordinateErrorReport(game.emptyCoordinates());
    }
}
